package com.app.service;

import java.util.List;

import com.app.exception.ClintProduceDetailsException;
import com.app.exception.PlantException;
import com.app.exception.UserException;
import com.app.model.ClintProduceDetails;

public interface ClintProduceDetailsService {
	
	public ClintProduceDetails addProductForSelling(ClintProduceDetails clintProduceDetails) throws ClintProduceDetailsException, UserException, PlantException ;
	
	public ClintProduceDetails getClintProduceDetails(Integer userId) throws ClintProduceDetailsException ;
	
	public List<ClintProduceDetails> getClintProduceDetailsByPlantId(Integer plantId) throws ClintProduceDetailsException;
	
	public ClintProduceDetails getClintProduceDetailsById(Integer clintId) throws ClintProduceDetailsException;
}
