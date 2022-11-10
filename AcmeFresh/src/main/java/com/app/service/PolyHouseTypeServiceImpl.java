package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.InstallationOrdersExeption;
import com.app.exception.PolyHouseTypeException;
import com.app.model.PolyHouseType;
import com.app.repository.PolyHouseTypeReop;

@Service
public class PolyHouseTypeServiceImpl implements PolyHouseTypeService {

	@Autowired
	private PolyHouseTypeReop polyHouseRepo;
	
	@Override
	public PolyHouseType addPolyHouseType(PolyHouseType polyHouseType) throws PolyHouseTypeException {
		
		PolyHouseType currentPolyHouse = polyHouseRepo.findByType(polyHouseType.getType());
		
		if(currentPolyHouse != null) 
			throw new PolyHouseTypeException("Polyhouse type : "+ polyHouseType.getType() +" is already Present") ;
		
		return polyHouseRepo.save(polyHouseType);
	}

	@Override
	public PolyHouseType updatePriceofPolyHouse(Integer polyHouseId, Double price) throws PolyHouseTypeException {
		PolyHouseType currentPolyHouse = polyHouseRepo.findById(polyHouseId)
												.orElseThrow(() -> new PolyHouseTypeException("Invalid polyHouseId: "+ polyHouseId)) ;
		
		currentPolyHouse.setRatePerSqMeter(price);
		return polyHouseRepo.save(currentPolyHouse); 
	}

	@Override
	public PolyHouseType getPolyHouseById(Integer id) throws PolyHouseTypeException {
		
		return  polyHouseRepo.findById(id).orElseThrow(()-> new PolyHouseTypeException("Invalid PolyHouseId Provided: "+id)) ;
	}

	@Override
	public List<PolyHouseType> getAllPolyHouses() throws PolyHouseTypeException {

		return polyHouseRepo.findAll();
	}

}
