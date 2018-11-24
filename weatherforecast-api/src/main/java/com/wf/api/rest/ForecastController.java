package com.wf.api.rest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wf.api.model.Forecast;
import com.wf.api.service.ForecastService;

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
	
	@GetMapping("/get")
    public @ResponseBody ResponseEntity<List<Forecast>> getForecast() throws ParseException
	{
		List<Forecast> listForecast = new ArrayList<Forecast>();
		Calendar c = Calendar.getInstance();
		LocalDate todayDate = LocalDate.now();
		
		Forecast forecast = forecastService.findByDate(todayDate);
		listForecast.add(forecast);
		
		IntStream.range(1, 4).forEach(i->	{
												LocalDate nextDate = todayDate.plusDays(i);
												Forecast nextForecast = forecastService.findByDate(nextDate);
												listForecast.add(nextForecast);
											});
		
		
		return new ResponseEntity<>(listForecast, HttpStatus.OK); 
		
	}
}
