package com.wf.api.weather.helper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "place")
@XmlAccessorType(XmlAccessType.FIELD)
public class Place {
	
	private Long placeId;
	
	@XmlElement
	private String name;
	
	@XmlElement(name = "phenomenon")
	private String phenomenon;
	 
	@XmlElement(name = "tempmin")
	private float minTemperature;
	
	@XmlElement(name = "tempmax")
	private float maxTemperature;
	 

}
