package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Plant;

public interface PlantRepo extends JpaRepository<Plant, Integer> {

}
