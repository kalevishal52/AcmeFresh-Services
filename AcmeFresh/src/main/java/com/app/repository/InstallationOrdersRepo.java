package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.InstallationOrders;

public interface InstallationOrdersRepo extends JpaRepository<InstallationOrders, Integer> {

}
