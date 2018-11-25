package com.wf.api.schedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wf.api.weather.helper.Forecasts;
import com.wf.api.service.ForecastService;
import com.wf.api.weather.WeatherClient;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WeatherDataCollector {
	
	//flag that decides scheduler run
	@Value("${weather.scheduler.enable}")
    private boolean weatherSchedulerEnabled;
	
	@Autowired
	WeatherClient weatherClient;
	
	@Autowired
	ForecastService forecastService;
	
	
	/**
	 * Scheduler that runs every 30 minutes
	 * fetches weather data from http://www.ilmateenistus.ee/ilma_andmed/xml/forecast.php?lang=eng and save in database
	 */
	@Scheduled(fixedRate = 1000*60*30)
	public void collectWeatherData() {
		
		if (!weatherSchedulerEnabled) {
			
			return;
		}
		log.info("collectWeatherData scheduler called...");
		
		Forecasts forecasts = weatherClient.fetchWeatherData();
		if(forecasts != null) {
			
			forecastService.saveForecast(forecasts);
			log.info("weather data are successfully saved in database");
		}
		else {
			log.info("weather data are null from weather URL");
		}
	}
}
