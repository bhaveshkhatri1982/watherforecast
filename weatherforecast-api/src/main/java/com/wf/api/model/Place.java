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
@Table(name="place")
public class Place {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="place_id")	
	private Long placeId;
	
	@Column
	private String name;
	
}
