package com.weather.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeatherReportItemApplication {
	public static void main(String[] args) {
		SpringApplication.run(WeatherReportItemApplication.class, args);
	}
}
