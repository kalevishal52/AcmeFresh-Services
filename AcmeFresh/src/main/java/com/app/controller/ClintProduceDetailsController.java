package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.ClintProduceDetailsException;
import com.app.exception.PlantException;
import com.app.exception.UserException;
import com.app.model.ClintProduceDetails;
import com.app.model.ProductOrders;
import com.app.service.ClintProduceDetailsService;

@RestController
@RequestMapping("/acmefresh")
public class ClintProduceDetailsController {

	@Autowired 
	private ClintProduceDetailsService clintProduceervice;
	
	
	@PostMapping("/products/")
	public ResponseEntity<ClintProduceDetails> addFinalProductHandler(@RequestBody ClintProduceDetails details) throws ClintProduceDetailsException, UserException, PlantException {
		
		ClintProduceDetails savedProductDetals = clintProduceervice.addProductForSelling(details);
		
		return new ResponseEntity<ClintProduceDetails>(savedProductDetals,HttpStatus.CREATED) ;
	}
	
	@GetMapping("/products/")
	public ResponseEntity<List<ClintProduceDetails>> getProductsByPlantId(@RequestParam("plantId") Integer plantId) throws ClintProduceDetailsException {
		
		List<ClintProduceDetails> productList =  clintProduceervice.getClintProduceDetailsByPlantId(plantId);
		
		return new ResponseEntity<List<ClintProduceDetails>>(productList,HttpStatus.OK) ;
	}
	
	
	
	
}
