package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.PlantException;
import com.app.model.Plant;
import com.app.repository.PlantRepo;

@Service
public class PlantServiceImpl implements PlantService {

	@Autowired
	private PlantRepo plantRepo;
	
	@Override
	public Plant addPlantDetails(Plant plant) throws PlantException {
		
		
		return plantRepo.save(plant);
	}

	@Override
	public Plant updatePlantDetails(Plant Plant) throws PlantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plant> getPlantsListByIds(List<Integer> plantIds) throws PlantException {
		List<Plant> plantsList = new ArrayList<>();
		
		for(Integer plantId : plantIds) {
			Plant plant = plantRepo.findById(plantId).orElseThrow(() -> new PlantException("Invalid plantID "+plantId)) ;
			plantsList.add(plant);
		}
		return plantsList;
	}

	@Override
	public Plant getPlantById(Integer plantId) throws PlantException {
		Plant plant = plantRepo.findById(plantId).orElseThrow(() -> new PlantException("Invalid plantID "+plantId)) ;

		return plant;
	}

}







