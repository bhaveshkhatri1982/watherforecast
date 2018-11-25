package com.wf.api.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wf.api.model.ForecastDetail;


@Repository("forecastDetailRepository")
@Scope("prototype")
public interface ForecastDetailRepository extends CrudRepository<ForecastDetail, Long>{

}

