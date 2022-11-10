package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.ClintProduceDetailsException;
import com.app.exception.ProductOrdersException;
import com.app.exception.UserException;
import com.app.model.ProductOrders;
import com.app.model.dto.OrderDTO;
import com.app.service.ProductOrdersService;

@RestController
@RequestMapping("/acmefresh")
public class ProductOrdersController {

	@Autowired
	private ProductOrdersService ordersService;
	
	@PostMapping("/orders/")
	public ResponseEntity<ProductOrders> addOrder(@RequestBody OrderDTO orderDTO) throws ProductOrdersException, ClintProduceDetailsException, UserException {
		
		ProductOrders savedOrder =  ordersService.addOrderofProduct(orderDTO);
		
		return new ResponseEntity<ProductOrders>(savedOrder,HttpStatus.OK) ;
	}
	
	@PostMapping("/orders/conform")
	public ResponseEntity<ProductOrders> conformOrder(@RequestParam("productOrderID") Integer  productId,
													@RequestParam("totalAmount") Double totalAmount) throws ProductOrdersException, ClintProduceDetailsException, UserException {
		
		ProductOrders savedOrder =  ordersService.conformOrder(productId, totalAmount);
		
		return new ResponseEntity<ProductOrders>(savedOrder,HttpStatus.OK) ;
	}
	
}
