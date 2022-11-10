package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer plantId;
	private String name;
	private String plantType;
	private Double seedReatePerUnit;
	
//	private Double productRatePerUnit;
//	private Double buyingRatePerUnit;
}
