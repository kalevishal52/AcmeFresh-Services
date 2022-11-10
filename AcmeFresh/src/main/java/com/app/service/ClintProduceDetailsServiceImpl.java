package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.ClintProduceDetailsException;
import com.app.exception.PlantException;
import com.app.exception.UserException;
import com.app.model.ClintProduceDetails;
import com.app.model.Plant;
import com.app.model.User;
import com.app.repository.ClintProduceDetailsRepo;

@Service
public class ClintProduceDetailsServiceImpl implements ClintProduceDetailsService {

	@Autowired
	private ClintProduceDetailsRepo clintProduceRepo;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private PlantService plantService;
	
	@Override
	public ClintProduceDetails addProductForSelling(ClintProduceDetails clintProduceDetails) throws ClintProduceDetailsException, UserException, PlantException {
		
		User user = userService.getUserById(clintProduceDetails.getUser().getUserId());
		
		Plant plant = plantService.getPlantById(clintProduceDetails.getPlantId());
		
		clintProduceDetails.setPlantName(plant.getName());
		clintProduceDetails.setUser(user);
		
		return clintProduceRepo.save(clintProduceDetails);
	}


	@Override
	public List<ClintProduceDetails> getClintProduceDetailsByPlantId(Integer plantId)
			throws ClintProduceDetailsException {
		
		List<ClintProduceDetails> clintProduceList = clintProduceRepo.getClintProduceByPlantId(plantId);
		
		if(clintProduceList.size() == 0) 
			throw new ClintProduceDetailsException("Opps! PlantsProduct whth id :"+plantId+" are out of stock") ;
		
		return clintProduceList;
	}
	
	@Override
	public ClintProduceDetails getClintProduceDetailsById(Integer clintId) throws ClintProduceDetailsException {
		// TODO Auto-generated method stub
		return clintProduceRepo.findById(clintId).orElseThrow(()-> new ClintProduceDetailsException("Invalid Clint Id "+clintId )) ;
	}
	
	
	@Override
	public ClintProduceDetails getClintProduceDetails(Integer userId) throws ClintProduceDetailsException {
		
		return null;
	}


}
