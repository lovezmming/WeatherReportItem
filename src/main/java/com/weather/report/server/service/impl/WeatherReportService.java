package com.weather.report.server.service.impl;

import com.weather.report.common.model.WeatherIndicatorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WeatherReportService {
    private static WeatherIndicatorDTO weatherIndicatorDTO = new WeatherIndicatorDTO();

    @Autowired
    private WeatherRegisterService weatherRegisterService;

    public void updateLatestWeatherIndicator(WeatherIndicatorDTO weatherIndicator) {
        log.info("WeatherReportService updateWeatherIndicator weatherIndicator: {}", weatherIndicator);
        weatherIndicatorDTO = weatherIndicator;
        weatherRegisterService.getAllClientServerList().forEach(s -> {
            s.updateWeatherIndicator(weatherIndicatorDTO);
        });
    }
}
