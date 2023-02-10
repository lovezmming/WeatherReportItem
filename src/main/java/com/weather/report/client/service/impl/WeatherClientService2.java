package com.weather.report.client.service.impl;

import com.weather.report.client.service.IWeatherClientService;
import com.weather.report.common.model.WeatherIndicatorDTO;
import com.weather.report.server.service.impl.WeatherRegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Slf4j
public class WeatherClientService2 implements IWeatherClientService {
    private static WeatherIndicatorDTO weatherIndicatorDTO;

    @Autowired
    private WeatherRegisterService weatherRegisterService;

    @PostConstruct
    private void register() {
        weatherIndicatorDTO = new WeatherIndicatorDTO();
        weatherRegisterService.registerWeatherClient(this);
    }

    @PreDestroy
    private void unRegister() {
        weatherRegisterService.removeClient(this);
    }

    @Override
    public void updateWeatherIndicator(WeatherIndicatorDTO weatherIndicator) {
        weatherIndicatorDTO = weatherIndicator;
        log.info("WeatherClientService2 updateWeatherIndicator weatherIndicatorDTO: {}", weatherIndicatorDTO);
    }
}
