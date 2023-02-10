package com.weather.report.server.service.impl;

import com.weather.report.client.service.IWeatherClientService;
import com.weather.report.server.service.IWeatherRegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class WeatherRegisterService implements IWeatherRegisterService {
    private static List<IWeatherClientService> weatherClientServiceList;

    @PostConstruct
    private void initServiceList() {
        weatherClientServiceList = new ArrayList<>();
    }

    public List<IWeatherClientService> getAllClientServerList() {
        log.info("getAllClientServerList server size: {}", weatherClientServiceList.size());
        return weatherClientServiceList;
    }

    @Override
    public void registerWeatherClient(IWeatherClientService service) {
        log.info("registerWeatherClient server size: {}", weatherClientServiceList.size());
        weatherClientServiceList.add(service);
    }

    @Override
    public void removeClient(IWeatherClientService service) {
        weatherClientServiceList.remove(service);
    }
}
