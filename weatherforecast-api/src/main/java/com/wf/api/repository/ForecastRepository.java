package com.wf.api.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.wf.api.model.Forecast;

import org.springframework.data.repository.CrudRepository;


@Repository("forecastRepository")
@Scope("prototype")
public interface ForecastRepository extends CrudRepository<Forecast, Integer>
{
	public Forecast findTopByDateOrderByForecastIdDesc(LocalDate date); 
}

