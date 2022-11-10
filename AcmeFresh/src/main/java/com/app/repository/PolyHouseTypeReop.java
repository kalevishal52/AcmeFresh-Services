package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.PolyHouseType;

public interface PolyHouseTypeReop extends JpaRepository<PolyHouseType, Integer> {

	public PolyHouseType findByType(String type) ;
	
}
