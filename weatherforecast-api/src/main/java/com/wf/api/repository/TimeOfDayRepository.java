package com.wf.api.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wf.api.model.TimeOfDay;


@Repository("timeOfDayRepository")
@Scope("prototype")
public interface TimeOfDayRepository extends CrudRepository<TimeOfDay, Long>{
	
	TimeOfDay findByLabel(String label);
}

