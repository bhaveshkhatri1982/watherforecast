package com.wf.api.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="forecast")
public class Forecast {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="forecast_id")	
	private Long forecastId;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column
	private LocalDate date;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "forecast")
	private List<ForecastDetail> listForecastDetail;
	
}