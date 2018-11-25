package com.wf.api.repository;

import java.time.LocalDate;

import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wf.api.model.Forecast;


@Repository("forecastRepository")
@Scope("prototype")
public interface ForecastRepository extends CrudRepository<Forecast, Long>{
	
	public Forecast findTopByDateOrderByForecastIdDesc(LocalDate date); 
}

