package com.wf.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="time_of_day")
public class TimeOfDay {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="time_of_day_id")	
	private Long timeOfDayId;
	
	@Column(unique=true)
	private String label;
}
