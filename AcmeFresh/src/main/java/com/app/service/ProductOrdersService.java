package com.app.service;

import com.app.exception.ClintProduceDetailsException;
import com.app.exception.ProductOrdersException;
import com.app.exception.UserException;
import com.app.model.ProductOrders;
import com.app.model.dto.OrderDTO;

public interface ProductOrdersService {

	public ProductOrders addOrderofProduct(OrderDTO orderDTO) throws ProductOrdersException, ClintProduceDetailsException, UserException;
	
	public ProductOrders conformOrder(Integer productOrderId, Double totalPriceAmount) throws ProductOrdersException, ClintProduceDetailsException;
}
