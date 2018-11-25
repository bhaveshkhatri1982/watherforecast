package com.wf.api.schedular;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherDataCollectorTest {

	@SpyBean
	WeatherDataCollector weatherDataCollector;
	
	
	@Test
    public void testScheduledCollectWeatherData() throws InterruptedException {
		
		Thread.sleep(1000 * 5);
		verify(weatherDataCollector, atLeast(1)).collectWeatherData();
    }
    
}
