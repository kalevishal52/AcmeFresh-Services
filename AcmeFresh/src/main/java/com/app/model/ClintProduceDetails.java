package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClintProduceDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer produceDeatilsId;
	
	private Integer plantId;
	private String plantName;

	private Double pricePerUnit;
	private Integer quantityPerUnit;
	
	@OneToOne
	private User user;
	
}
