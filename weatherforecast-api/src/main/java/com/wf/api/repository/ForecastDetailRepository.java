package com.wf.api.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.wf.api.model.Forecast;
import com.wf.api.model.ForecastDetail;

import org.springframework.data.repository.CrudRepository;


@Repository("forecastDetailRepository")
@Scope("prototype")
public interface ForecastDetailRepository extends CrudRepository<ForecastDetail, Integer>
{

}

