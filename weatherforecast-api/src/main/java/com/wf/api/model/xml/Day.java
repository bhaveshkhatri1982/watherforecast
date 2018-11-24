package com.wf.api.model.xml;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "day")
@XmlAccessorType(XmlAccessType.FIELD)
public class Day {
	
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
