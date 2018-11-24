package com.wf.api.rest;

import com.wf.api.ApiApplication;
import com.wf.api.service.ForecastService;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApiApplication.class)
@WebAppConfiguration
public class ForecastControllerTest extends TestCase {
	
	private final String BASE_URI = "http://localhost:8080/api/v1/weather/";
	
	private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    ForecastService forecastService;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetForecast() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URI+"/get")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
