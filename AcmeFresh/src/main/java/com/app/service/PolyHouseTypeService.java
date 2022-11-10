package com.app.service;

import java.util.List;

import com.app.exception.PolyHouseTypeException;
import com.app.model.PolyHouseType;

public interface PolyHouseTypeService {

	public PolyHouseType addPolyHouseType(PolyHouseType polyHouseType) throws PolyHouseTypeException;
	
	public PolyHouseType updatePriceofPolyHouse(Integer polyHouseId,Double price) throws PolyHouseTypeException; ;
	
	public PolyHouseType getPolyHouseById(Integer id) throws PolyHouseTypeException;
	
	public List<PolyHouseType> getAllPolyHouses() throws PolyHouseTypeException;
}
