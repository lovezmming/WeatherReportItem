package com.weather.report.server.service.impl;

import com.weather.report.client.service.IWeatherClientService;
import com.weather.report.common.model.WeatherIndicatorDTO;
import com.weather.report.server.service.IWeatherIndicatorService;
import com.weather.report.server.service.IWeatherRegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class WeatherRegisterService implements IWeatherRegisterService {
    @Autowired
    private IWeatherIndicatorService iWeatherIndicatorService;

    private static List<IWeatherClientService> weatherClientServiceList = new ArrayList<>();

    @Override
    public void registerWeatherClient(IWeatherClientService service) {
        weatherClientServiceList.add(service);
    }

    @Override
    public void removeClient(IWeatherClientService service) {
        weatherClientServiceList.remove(service);
    }

    @Override
    public void notifyAllClient() {
        log.info("WeatherRegisterService notifyAllClient!");
        WeatherIndicatorDTO weatherIndicatorDTO = iWeatherIndicatorService.getLastWeatherIndicator();
        if (weatherClientServiceList.size() == 0) {
            log.warn("WeatherRegisterService weatherClient is empty!");
            return;
        }
        weatherClientServiceList.forEach(iWeatherClientService -> {
            iWeatherClientService.updateWeatherIndicator(weatherIndicatorDTO);
        });
    }
}
