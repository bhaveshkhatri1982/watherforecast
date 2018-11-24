package com.wf.api.schedular;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.wf.api.model.Forecast;
import com.wf.api.model.xml.ForecastXML;
import com.wf.api.model.xml.Forecasts;
import com.wf.api.service.ForecastService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WeatherDataCollector {
	
	@Value("${weather.scheduler.enable}")
    private boolean weatherSchedulerEnabled;
	
	@Autowired
	ForecastService forecastService;
	
	@Scheduled(fixedRate = 1000*60*30) // every 30 minutes
	public void collectWeatherData() {
		
		if (!weatherSchedulerEnabled) {
			return;
		}
		
		// pull data from example REST API
		RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        String url = "http://www.ilmateenistus.ee/ilma_andmed/xml/forecast.php?lang=eng";
        ResponseEntity<Forecasts> res = rt.exchange(url, HttpMethod.GET, entity, Forecasts.class);
        log.info("Forecast = "+res.getBody().getListForecastXML().get(0).getDay().getPhenomenon());
        Forecasts forecasts = res.getBody();
        forecastService.saveForecast(forecasts);
        
        /*
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		Forecast forecast = new Forecast();
		try {
			
			date = formatter.parse("2018-11-24");
			forecast = forecastService.findByDate(date);
	        log.info("date = "+forecast.getDate());
	        log.info("id = "+forecast.getForecastId());
	        log.info("forecast detail size = "+forecast.getListForecastDetail().size());
	        log.info("forecast place detail size = "+forecast.getListForecastDetail().get(0).getListForecastPlaceDetail().size());
	        log.info("forecast place detail size = "+forecast.getListForecastDetail().get(0).getListForecastPlaceDetail().get(0).getPlace().getName());
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
        */
        
	}
}
