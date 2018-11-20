package com.wf.api.model;

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
	
	 @XmlElement(name = "phenomenon")
	 private String phenomenon;
}
