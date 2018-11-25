package com.wf.api.repository;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wf.api.ApiApplication;
import com.wf.api.model.Place;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class PlaceRepositoryTest {
	
	@Autowired
	private PlaceRepository placeRepository;
	
	
	@After
    public void cleanup() throws Exception {
		
		Place testPlace = placeRepository.findByName("Tallinn");
		placeRepository.deleteById(testPlace.getPlaceId());
	}
	
	@Test
    public void shouldSaveAndFetchPlace() throws Exception {
		
		Place place = new Place();
		place.setName("Tallinn");
		placeRepository.save(place);

		Place maybePlace = placeRepository.findByName("Tallinn");
        assertThat(maybePlace, hasProperty("name", equalTo("Tallinn")));
	}
	
}
