package com.weather.report.server.service.impl;

import com.weather.report.common.model.WeatherIndicatorDTO;
import com.weather.report.server.service.IWeatherIndicatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WeatherIndicatorService implements IWeatherIndicatorService {
    private static WeatherIndicatorDTO weatherIndicatorDTO = new WeatherIndicatorDTO();

    @Override
    public void updateNewWeatherIndicator(WeatherIndicatorDTO weatherIndicator) {
        log.info("updateWeatherIndicator weatherIndicator: {}", weatherIndicator);
        weatherIndicatorDTO.setHumidity(weatherIndicator.getHumidity());
        weatherIndicatorDTO.setPressure(weatherIndicator.getPressure());
        weatherIndicatorDTO.setTemperature(weatherIndicator.getTemperature());
    }

    @Override
    public WeatherIndicatorDTO getLastWeatherIndicator() {
        return weatherIndicatorDTO;
    }
}
