package com.app.service;

import java.util.List;

import com.app.exception.PlantException;
import com.app.model.Plant;

public interface PlantService {

	public Plant addPlantDetails(Plant plant) throws PlantException;
	
	public Plant updatePlantDetails(Plant Plant) throws PlantException;
	
	public List<Plant> getPlantsListByIds(List<Integer> plantIds) throws PlantException;
	
	public Plant getPlantById(Integer plnatId) throws PlantException; 
}
