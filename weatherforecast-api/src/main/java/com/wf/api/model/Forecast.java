package com.wf.api.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "forecast")
@XmlAccessorType(XmlAccessType.FIELD)
public class Forecast {
	
	//@XmlAttribute(name = "date")
	//private String date;
	
	 @XmlElement(name = "night", type=Night.class)
	 private Night night;
}
