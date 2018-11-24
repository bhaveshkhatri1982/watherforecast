package com.wf.api.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.wf.api.model.Forecast;
import com.wf.api.model.ForecastDetail;
import com.wf.api.model.ForecastPlaceDetail;
import com.wf.api.model.Place;
import com.wf.api.model.TimeOfDay;
import com.wf.api.model.xml.ForecastXML;
import com.wf.api.model.xml.Forecasts;
import com.wf.api.repository.ForecastDetailRepository;
import com.wf.api.repository.ForecastPlaceDetailRepository;
import com.wf.api.repository.ForecastRepository;
import com.wf.api.repository.PlaceRepository;
import com.wf.api.repository.TimeOfDayRepository;
import com.wf.api.utility.Constants;

import org.springframework.data.repository.CrudRepository;


@Service("forecastService")
@Scope("prototype")
public class ForecastService 
{
	@Autowired
    private ForecastRepository forecastRepository;
	
	@Autowired
    private ForecastDetailRepository forecastDetailRepository;
	
	@Autowired
    private TimeOfDayRepository timeOfDayRepository;
	
	@Autowired
    private PlaceRepository placeRepository;
	
	@Autowired
	ForecastPlaceDetailRepository forecastPlaceDetailRepository;
	
	public void saveForecast(Forecasts forecasts) {
		
		
		forecasts
		.getListForecastXML()
		.stream()
		.forEachOrdered(forecastXMl ->	{
			
											Forecast forecast = new Forecast();
											DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
											LocalDate date= LocalDate.parse(forecastXMl.getDate(), formatter);
											forecast.setDate(date);
											forecastRepository.save(forecast);
			
											// Saving night forecast
											ForecastDetail nightForecastDetail = new ForecastDetail();
											nightForecastDetail.setForecast(forecast);
											
											TimeOfDay nightTimeOfDay = timeOfDayRepository.findByLabel(Constants.NIGHT);
											nightForecastDetail.setTimeOfDay(nightTimeOfDay);
											
											nightForecastDetail.setPhenomenon(forecastXMl.getNight().getPhenomenon());
											nightForecastDetail.setMinTemperature(forecastXMl.getNight().getMinTemperature());
											nightForecastDetail.setMaxTemperature(forecastXMl.getNight().getMaxTemperature());
											nightForecastDetail.setText(forecastXMl.getNight().getText());
											
											forecastDetailRepository.save(nightForecastDetail);
											
											if(forecastXMl.getNight().getListPlace() != null)
											{	
												forecastXMl
												.getNight()
												.getListPlace()
												.stream()
												.forEach(p->	{
																	Place place; 
																	place = placeRepository.findByName(p.getName());
																	if(place == null)
																	{	
																		place = new Place();
																		place.setName(p.getName());
																		placeRepository.save(place);
																	}
																	ForecastPlaceDetail forecastPlaceDetail = new ForecastPlaceDetail();
																	forecastPlaceDetail.setForecastDetail(nightForecastDetail);
																	forecastPlaceDetail.setPlace(place);
																	forecastPlaceDetail.setPhenomenon(p.getPhenomenon());
																	forecastPlaceDetail.setMinTemperature(p.getMinTemperature());
																	
																	forecastPlaceDetailRepository.save(forecastPlaceDetail);
																});
											
											}
											// Saving day forecast
											ForecastDetail dayForecastDetail = new ForecastDetail();
											dayForecastDetail.setForecast(forecast);
													
											TimeOfDay dayTimeOfDay = timeOfDayRepository.findByLabel(Constants.DAY);
											dayForecastDetail.setTimeOfDay(dayTimeOfDay);
											
											dayForecastDetail.setPhenomenon(forecastXMl.getDay().getPhenomenon());
											dayForecastDetail.setMinTemperature(forecastXMl.getDay().getMinTemperature());
											dayForecastDetail.setMaxTemperature(forecastXMl.getDay().getMaxTemperature());
											dayForecastDetail.setText(forecastXMl.getDay().getText());
											
											forecastDetailRepository.save(dayForecastDetail);
											
											if(forecastXMl.getDay().getListPlace() != null)
											{
												forecastXMl
												.getDay()
												.getListPlace()
												.stream()
												.forEach(p->	{
																	Place place; 
																	place = placeRepository.findByName(p.getName());
																	if(place == null)
																	{	
																		place = new Place();
																		place.setName(p.getName());
																		placeRepository.save(place);
																	}
																	ForecastPlaceDetail forecastPlaceDetail = new ForecastPlaceDetail();
																	forecastPlaceDetail.setForecastDetail(dayForecastDetail);
																	forecastPlaceDetail.setPlace(place);
																	forecastPlaceDetail.setPhenomenon(p.getPhenomenon());
																	forecastPlaceDetail.setMaxTemperature(p.getMaxTemperature());
																	
																	forecastPlaceDetailRepository.save(forecastPlaceDetail);
																});
											}
											
										});
											
	}
	
	
	public Forecast findByDate(LocalDate date)
	{
		return forecastRepository.findTopByDateOrderByForecastIdDesc(date);
	}
	
	
	
}

