package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.PlantException;
import com.app.model.Plant;
import com.app.service.PlantService;

@RestController
@RequestMapping("/acmefresh")
public class PlantController {

	@Autowired
	private PlantService plantService;
	
	@PostMapping("/plants/")
	public ResponseEntity<Plant> addPlantsDetailsHandler(@RequestBody Plant plant) throws PlantException {
		
		Plant savedPlant = plantService.addPlantDetails(plant);
		
		return new ResponseEntity<Plant>(savedPlant,HttpStatus.ACCEPTED) ;
	}
	
}
