package com.weather.report.server.task;

import com.weather.report.common.model.WeatherIndicatorDTO;
import com.weather.report.server.service.impl.WeatherReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class WeatherReportTask {
    private Random random = new Random();

    @Autowired
    private WeatherReportService weatherReportService;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void weatherReport() {
        WeatherIndicatorDTO weatherIndicatorDTO = new WeatherIndicatorDTO();
        weatherIndicatorDTO.setTemperature(random.nextFloat());
        weatherIndicatorDTO.setPressure(random.nextFloat());
        weatherIndicatorDTO.setHumidity(random.nextFloat());
        log.info("WeatherReportTask set Weather Indicator: {}", weatherIndicatorDTO);
        weatherReportService.updateLatestWeatherIndicator(weatherIndicatorDTO);
    }
}
