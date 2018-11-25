package com.wf.api.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "forecast", cascade=CascadeType.ALL)
	private List<ForecastDetail> listForecastDetail;
}