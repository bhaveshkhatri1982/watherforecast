package com.wf.api.schedular;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
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
import com.wf.api.model.Forecasts;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WeatherDataCollector {
	
	@Value("${weather.scheduler.enable}")
    private boolean weatherSchedulerEnabled;
	
	@Scheduled(fixedRate = 1000*60*1) // every 30 seconds
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
        log.info("Forecast = "+res.getBody().getForecast().get(0).getNight().getPhenomenon());
        
        
	}
}
