package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstallationOrders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	
	private Double requireInAreaPerSqMtr;
	private String billDesc;
	private Double totalBillAmount;
	
	@OneToOne
	private User user;
	
	@OneToOne
	private PolyHouseType polyHouseType;
	
	@OneToOne
	private NutrientFilmTechnique technique;
	
	@ManyToMany
	private List<Plant> plants = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address orderAddress;
}
