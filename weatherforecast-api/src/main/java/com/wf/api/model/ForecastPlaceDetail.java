package com.wf.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="forecast_place_detail")
public class ForecastPlaceDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="forecast_place_detail_id")	
	private Long forecastPlaceDetailId;
	
	@OneToOne
	@JoinColumn(name="forecast_detail_id")
	@JsonBackReference
	private ForecastDetail forecastDetail;
	
	@OneToOne
	@JoinColumn(name="place_id")
	private Place place;
	
	@Column
	private String phenomenon;
	 
	@Column(name = "min_temperature")
	private float minTemperature;
	
	@Column(name = "max_temperature")
	private float maxTemperature;
}
