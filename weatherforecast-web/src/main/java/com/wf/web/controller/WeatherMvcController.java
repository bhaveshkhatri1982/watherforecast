package com.wf.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class WeatherMvcController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome(ModelMap model) {
       
        return "index";
}

}
