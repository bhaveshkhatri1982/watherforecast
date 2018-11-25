package com.wf.api.rest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wf.api.model.Forecast;
import com.wf.api.model.Place;
import com.wf.api.service.ForecastService;
import com.wf.api.service.PlaceService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@CrossOrigin
@Controller
@RequestMapping(ForecastController.API_ROUTE_MAPPING)
public class ForecastController {
	
	static final String API_ROUTE_MAPPING = "/api/v1/weather";
	
	@Autowired
	ForecastService forecastService;
	
	@Autowired
	PlaceService placeService;
	
	/*
	 * This endpoint will give fully qualified json object for current day's location wise weather data along with weather data for next 3 days
	 */
	@GetMapping("/get")
    public @ResponseBody ResponseEntity<List<Forecast>> getForecast(){
		
		List<Forecast> listForecast = new ArrayList<Forecast>();
		
		// Start from today's date and go through next 4 day. API does not provide current date information for all calls made by scheduler after afternoon.
		LocalDate todayDate = LocalDate.now();
		
		Forecast forecast = forecastService.findByDate(todayDate);
		if(forecast != null)
			listForecast.add(forecast);
		
		IntStream
		.range(1, 4)
		.forEach(i->	{
							LocalDate nextDate = todayDate.plusDays(i);
							Forecast nextForecast = forecastService.findByDate(nextDate);
							if(nextForecast != null)
								listForecast.add(nextForecast);
						});
		return new ResponseEntity<>(listForecast, HttpStatus.OK); 
	}
	
	@GetMapping("/get/cities")
    public @ResponseBody ResponseEntity<List<Place>> getAllCities(){
		
		List<Place> listPlace = placeService.getAllCities();
		
		if(listPlace != null && listPlace.size()>0)
			return new ResponseEntity<>(listPlace, HttpStatus.OK); 
		else
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
}
