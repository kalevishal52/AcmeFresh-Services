package com.app.model.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstallationDTO {
	
	private Integer userId;
	private Double requireInAreaPerSqMtr;
	private Integer polyHouseTypeId;
	private Integer nftId;
	private Map<Integer, Integer> plantIdWithQuantity = new HashMap<>();
	
	private Address address;
}
