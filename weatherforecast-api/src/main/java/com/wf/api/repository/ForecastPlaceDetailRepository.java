package com.wf.api.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.wf.api.model.Forecast;
import com.wf.api.model.ForecastDetail;
import com.wf.api.model.ForecastPlaceDetail;

import org.springframework.data.repository.CrudRepository;


@Repository("forecastPlaceDetailRepository")
@Scope("prototype")
public interface ForecastPlaceDetailRepository extends CrudRepository<ForecastPlaceDetail, Integer>
{
	
}

