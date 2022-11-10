package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.ProductOrders;

public interface ProductOrderRepo extends JpaRepository<ProductOrders, Integer> {

}
