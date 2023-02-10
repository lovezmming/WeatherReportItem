package com.weather.report.server.service;

import com.weather.report.client.service.IWeatherClientService;

public interface IWeatherRegisterService {
    void registerWeatherClient(IWeatherClientService service);
    void removeClient(IWeatherClientService service);
}
