package com.wf.api.weather.helper;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "night")
@XmlAccessorType(XmlAccessType.FIELD)
public class Night {
	
	@XmlElement
	private String phenomenon;
	 
	@XmlElement(name = "tempmin")
	private float minTemperature;
	 
	@XmlElement(name = "tempmax")
	private float maxTemperature;
	 
	@XmlElement
	private String text;
	
	
	@XmlElement(name = "place", type=Place.class)
	private List<Place> listPlace;
	
}
