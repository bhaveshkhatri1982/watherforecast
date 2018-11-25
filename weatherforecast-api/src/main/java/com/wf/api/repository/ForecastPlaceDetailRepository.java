package com.wf.api.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wf.api.model.ForecastPlaceDetail;


@Repository("forecastPlaceDetailRepository")
@Scope("prototype")
public interface ForecastPlaceDetailRepository extends CrudRepository<ForecastPlaceDetail, Long>{
	
}

