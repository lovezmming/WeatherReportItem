package com.weather.report.service;

import com.weather.report.client.service.impl.WeatherClientService;
import com.weather.report.client.service.impl.WeatherClientService2;
import com.weather.report.common.model.WeatherIndicatorDTO;
import com.weather.report.server.service.impl.WeatherReportService;
import com.weather.report.server.service.impl.WeatherRegisterService;
import org.junit.Assert;
import org.junit.Test;
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
    private WeatherReportService weatherReportService;
    @Autowired
    private WeatherRegisterService weatherRegisterService;

    @Test
    public void updateWeatherIndicatorTest() {
        // 服务启动 weatherClientService1与2 默认注册
        Assert.assertEquals(2, weatherRegisterService.getAllClientServerList().size());

        // 更新天气指标
        WeatherIndicatorDTO weatherIndicatorDTO = new WeatherIndicatorDTO();
        weatherIndicatorDTO.setTemperature(33f);
        weatherIndicatorDTO.setHumidity(35f);
        weatherIndicatorDTO.setPressure(30.4f);
        weatherReportService.updateLatestWeatherIndicator(weatherIndicatorDTO);

        // 移除客户端1
        weatherRegisterService.removeClient(weatherClientService);
        Assert.assertEquals(1, weatherRegisterService.getAllClientServerList().size());
        weatherIndicatorDTO.setTemperature(43f);
        weatherIndicatorDTO.setHumidity(45f);
        weatherIndicatorDTO.setPressure(40.4f);
        weatherReportService.updateLatestWeatherIndicator(weatherIndicatorDTO);

        // 移除客户端2后无客户端
        weatherRegisterService.removeClient(weatherClientService2);
        Assert.assertEquals(0, weatherRegisterService.getAllClientServerList().size());
        weatherIndicatorDTO.setTemperature(53f);
        weatherIndicatorDTO.setHumidity(55f);
        weatherIndicatorDTO.setPressure(50.4f);
        weatherReportService.updateLatestWeatherIndicator(weatherIndicatorDTO);
    }
}
