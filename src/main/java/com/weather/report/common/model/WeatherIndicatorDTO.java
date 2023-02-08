package com.weather.report.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WeatherIndicatorDTO {
    // 温度
    private float temperature;
    // 湿度
    private float humidity;
    // 压力
    private float pressure;
}
