package com.wf.api.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import com.wf.api.ApiApplication;
import com.wf.api.model.Forecast;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class ForecastRepositoryTest {
	
	@Autowired
	private ForecastRepository forecastRepository;
	
	
	@Before
	@After
    public void cleanup() throws Exception {
		
		forecastRepository.deleteAll();
	}
	
	@Test
    public void shouldSaveAndFetchForecast() throws Exception {
		Forecast forecast = new Forecast();
		
		forecast.setDate(LocalDate.now());
        
		forecastRepository.save(forecast);

        Forecast maybeForecast = forecastRepository.findTopByDateOrderByForecastIdDesc(LocalDate.now());

        assertThat(maybeForecast, hasProperty("date", equalTo(LocalDate.now())));
}
	
}
