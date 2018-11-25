package com.wf.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.wf.api.model.Forecast;
import com.wf.api.model.Place;
import com.wf.api.repository.ForecastRepository;
import com.wf.api.repository.PlaceRepository;


@Service("placeService")
@Scope("prototype")
public class PlaceService {
	
	@Autowired
    private PlaceRepository placeRepository;
	
	public List<Place> getAllCities(){
		
		return (List<Place>) placeRepository.findAll();
	}
	
}

