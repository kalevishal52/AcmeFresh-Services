package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.model.ClintProduceDetails;

public interface ClintProduceDetailsRepo extends JpaRepository<ClintProduceDetails, Integer> {

	@Query("from ClintProduceDetails c where c.plantId = ?1 AND c.quantityPerUnit > 0")
	public List<ClintProduceDetails> getClintProduceByPlantId(Integer plantId) ;
	
}
