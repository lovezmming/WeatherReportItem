package com.weather.report.client.service;

import com.weather.report.common.model.WeatherIndicatorDTO;

public interface IWeatherClientService {
    void updateWeatherIndicator(WeatherIndicatorDTO weatherIndicator);
}
