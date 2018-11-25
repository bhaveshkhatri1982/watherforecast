package com.wf.api.repository;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wf.api.ApiApplication;
import com.wf.api.model.TimeOfDay;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class TimeOFDayRepositoryTest {
	
	@Autowired
	private TimeOfDayRepository timeOFDayRepository;
	
	@SuppressWarnings("unchecked")
	@Test
    public void shouldFetchTimeOfDay() throws Exception {
	
		Iterable<TimeOfDay> maybeTimeOfDay = timeOFDayRepository.findAll();
		assertThat(maybeTimeOfDay, hasItems(hasProperty("label", equalTo("Day")), hasProperty("label", equalTo("Night"))));
	}
	
}
