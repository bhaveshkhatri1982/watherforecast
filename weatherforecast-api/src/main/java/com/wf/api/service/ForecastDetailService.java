package com.wf.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.wf.api.model.Forecast;
import com.wf.api.repository.ForecastRepository;


@Service("forecastDetailService")
@Scope("prototype")
public class ForecastDetailService 
{
	@Autowired
    private ForecastRepository forecastRepository;
	
	public void saveForecast(Forecast forecast) {
		forecastRepository.save(forecast);
	}
	
	
}

