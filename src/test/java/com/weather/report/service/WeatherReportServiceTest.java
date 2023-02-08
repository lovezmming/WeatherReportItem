package com.weather.report.service;

import com.weather.report.client.service.impl.WeatherClientService;
import com.weather.report.client.service.impl.WeatherClientService2;
import com.weather.report.common.model.WeatherIndicatorDTO;
import com.weather.report.server.service.impl.WeatherIndicatorService;
import com.weather.report.server.service.impl.WeatherRegisterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WeatherReportServiceTest {
    @Autowired
    private WeatherClientService weatherClientService;
    @Autowired
    private WeatherClientService2 weatherClientService2;
    @Autowired
    private WeatherIndicatorService weatherIndicatorService;
    @Autowired
    private WeatherRegisterService weatherRegisterService;

    @Test
    public void updateWeatherIndicatorTest() {
        // 注册2个客户端
        weatherRegisterService.registerWeatherClient(weatherClientService);
        weatherRegisterService.registerWeatherClient(weatherClientService2);

        // 更新天气指标
        WeatherIndicatorDTO weatherIndicatorDTO = new WeatherIndicatorDTO();
        weatherIndicatorDTO.setTemperature(23f);
        weatherIndicatorDTO.setHumidity(65f);
        weatherIndicatorDTO.setPressure(30.4f);
        weatherIndicatorService.updateNewWeatherIndicator(weatherIndicatorDTO);
        WeatherIndicatorDTO weatherIndicator = weatherIndicatorService.getLastWeatherIndicator();
        Assertions.assertEquals(weatherIndicator.getTemperature(), weatherIndicatorDTO.getTemperature());
        Assertions.assertEquals(weatherIndicator.getHumidity(), weatherIndicatorDTO.getHumidity());
        Assertions.assertEquals(weatherIndicator.getPressure(), weatherIndicatorDTO.getPressure());

        // 通知所有客户端
        weatherRegisterService.notifyAllClient();

        // 移除客户端1
        weatherRegisterService.removeClient(weatherClientService);
        weatherRegisterService.notifyAllClient();

        // 移除客户端2后无客户端
        weatherRegisterService.removeClient(weatherClientService2);
        weatherRegisterService.notifyAllClient();
    }
}
