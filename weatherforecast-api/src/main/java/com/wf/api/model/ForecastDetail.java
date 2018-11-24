package com.wf.api.model;

import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="forecast_detail")
public class ForecastDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="forecast_detail_id")	
	private Long forecastDetailId;
	
	@ManyToOne
	@JoinColumn(name="forecast_id")
	@JsonBackReference
	private Forecast forecast;
	
	@OneToOne
	@JoinColumn(name="time_of_day_id")
	private TimeOfDay timeOfDay;
	
	@Column
	private String phenomenon;
	 
	@Column(name = "min_temperature")
	private float minTemperature;
	 
	@Column(name = "max_temperature")
	private float maxTemperature;
	
	@Column
	private String text;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "forecastDetail")
	private List<ForecastPlaceDetail> listForecastPlaceDetail;
	
	
	
}
