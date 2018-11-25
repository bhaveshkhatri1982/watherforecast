package com.wf.api.weather;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.wf.api.weather.helper.Forecasts;
import com.wf.api.utility.Constants;

import lombok.extern.slf4j.Slf4j;

/**
 * This client fetches weather data from URL
 * @author Bhavesh Khatri
 *
 */
@Component
@Slf4j
public class WeatherClient {
	
	@Value("${weather.url}")
    private String weatherURL;
	
	public Forecasts fetchWeatherData() {
		
		Forecasts forecasts = null;
		RestTemplate rt = new RestTemplate();
		
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
        headers.add("user-agent", Constants.USER_AGENT);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        try{        
        	
        	ResponseEntity<Forecasts> res = rt.exchange(weatherURL, HttpMethod.GET, entity, Forecasts.class);
        	if(res.getBody()!=null){
        		
	        	forecasts = res.getBody();
	        	log.info("weather data are successfully fetched");
        	}
	    	else{
	    	
	    		log.info("url did not return weather data");
	    	}
        }
        catch(Exception e){
        
        	log.info("There are problems fetching weather data - exception message: "+e.getMessage());
        }	
        return forecasts;
	}
}
