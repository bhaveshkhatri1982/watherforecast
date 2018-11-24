package com.wf.api.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.wf.api.model.TimeOfDay;

import org.springframework.data.repository.CrudRepository;


@Repository("timeOfDayRepository")
@Scope("prototype")
public interface TimeOfDayRepository extends CrudRepository<TimeOfDay, Integer>
{
	TimeOfDay findByLabel(String label);
	
}

