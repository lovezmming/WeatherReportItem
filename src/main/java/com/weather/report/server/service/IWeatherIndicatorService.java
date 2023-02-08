package com.weather.report.server.service;

import com.weather.report.common.model.WeatherIndicatorDTO;

public interface IWeatherIndicatorService {
    void updateNewWeatherIndicator(WeatherIndicatorDTO weatherIndicator);
    WeatherIndicatorDTO getLastWeatherIndicator();
}
