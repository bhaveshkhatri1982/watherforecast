package com.wf.api.schedular;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
//import org.awaitility.Awaitility.*;
//import org.awaitility.Duration.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherDataCollectorTest {

	@SpyBean
	WeatherDataCollector weatherDataCollector;
	
	/*
	@Test
    public void jobRuns() {
        await().atMost(Duration.FIVE_SECONDS)
               .untilAsserted(() -> verify(weatherDataCollector, times(1)).collectWeatherData());
    }
    */
}
