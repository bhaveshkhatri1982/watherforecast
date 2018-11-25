package com.wf.api.service;

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
import com.wf.api.repository.ForecastRepository;
import com.wf.api.weather.WeatherClient;
import com.wf.api.weather.helper.Forecasts;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class ForecastServiceTest {
	
	@Autowired
	WeatherClient weatherClient;
	
	@Autowired
	ForecastService forecastService;
	
	@Test
    public void shouldFetchForecastFromUrlAndSave() throws Exception {
		
		Forecasts forecasts = weatherClient.fetchWeatherData();
		forecastService.saveForecast(forecasts);
		
		Forecast maybeNextForecast = forecastService.findByDate(LocalDate.now().plusDays(1));
		assertThat(maybeNextForecast, hasProperty("date", equalTo(LocalDate.now().plusDays(1))));
		
		Forecast maybeAnotherForecast = forecastService.findByDate(LocalDate.now().plusDays(2));
		assertThat(maybeAnotherForecast, hasProperty("date", equalTo(LocalDate.now().plusDays(2))));
	}
	
	
}
