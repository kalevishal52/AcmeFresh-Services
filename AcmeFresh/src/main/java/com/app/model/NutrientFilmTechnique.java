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
public class NutrientFilmTechnique {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer nftId;
	private Double channelSizeInMtrPerSqMtr;
	private Double nftRate;
	
}
