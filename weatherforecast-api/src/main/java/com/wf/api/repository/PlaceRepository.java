package com.wf.api.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wf.api.model.Place;


@Repository("placeRepository")
@Scope("prototype")
public interface PlaceRepository extends CrudRepository<Place, Long>{
	
	Place findByName(String name);
}

