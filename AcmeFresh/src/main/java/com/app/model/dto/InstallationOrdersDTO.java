package com.app.model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.app.model.Address;
import com.app.model.BillingDetails;
import com.app.model.NutrientFilmTechnique;
import com.app.model.Plant;
import com.app.model.PolyHouseType;
import com.app.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstallationOrdersDTO {

	private Integer orderId;
	
	private Double requireInAreaPerSqMtr;
	private String billDesc;
	private Double totalBillAmount;
	private User user;
	private PolyHouseType polyHouseType;
	private NutrientFilmTechnique technique;
	private List<Plant> plants = new ArrayList<>();
	private Address orderAddress;
	
}
