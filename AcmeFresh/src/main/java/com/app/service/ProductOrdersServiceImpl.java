package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.enums.OrderStatus;
import com.app.exception.ClintProduceDetailsException;
import com.app.exception.ProductOrdersException;
import com.app.exception.UserException;
import com.app.model.ClintProduceDetails;
import com.app.model.ProductOrders;
import com.app.model.User;
import com.app.model.dto.OrderDTO;
import com.app.repository.ClintProduceDetailsRepo;
import com.app.repository.ProductOrderRepo;

@Service
public class ProductOrdersServiceImpl implements ProductOrdersService {

	@Autowired
	private ClintProduceDetailsService clintProduceService;
	
	@Autowired
	private ProductOrderRepo orderRepo;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ClintProduceDetailsRepo clintProduceDetailsRepo;
	
	@Override
	public ProductOrders addOrderofProduct(OrderDTO orderDTO) throws ProductOrdersException, ClintProduceDetailsException, UserException {
		
		ClintProduceDetails sellerData = clintProduceService.getClintProduceDetailsById(orderDTO.getClintProduceDetailsId()) ;
		
		if(sellerData.getQuantityPerUnit() < orderDTO.getQuantity()) 
			throw new ProductOrdersException("Product Quantity not Available") ;
		
		User buyer =  userService.getUserById(orderDTO.getBuyerUserId());
		User seller = sellerData.getUser();
		
		ProductOrders productOrder = new ProductOrders();
		productOrder.setBuyer(buyer);
		productOrder.setOrderStatus(OrderStatus.CONFORMED);
		productOrder.setPlantId(sellerData.getPlantId());
		productOrder.setPlantName(sellerData.getPlantName());
		productOrder.setQuantity(orderDTO.getQuantity());
		productOrder.setSeller(seller);
		productOrder.setTotalOrderAmount(orderDTO.getQuantity() * sellerData.getPricePerUnit()); 
		productOrder.setClintProduceId(sellerData.getProduceDeatilsId());
		
		return orderRepo.save(productOrder);
	}
	
	public ProductOrders conformOrder(Integer productOrderId, Double totalPriceAmount) throws ProductOrdersException, ClintProduceDetailsException {
		
		ProductOrders order =  orderRepo.findById(productOrderId).orElseThrow(() -> new ProductOrdersException("Invalid productOrderId "+productOrderId)) ;

//		System.out.println(totalPriceAmount);
//		System.out.println(order.getTotalOrderAmount());

		if(!order.getTotalOrderAmount().equals(totalPriceAmount)) 
			throw new ProductOrdersException("Amount Doesn't match") ;
		
		ClintProduceDetails sellerData = clintProduceService.getClintProduceDetailsById(order.getClintProduceId()) ;
		sellerData.setQuantityPerUnit(sellerData.getQuantityPerUnit() - order.getQuantity());
		clintProduceDetailsRepo.save(sellerData) ;
		
		order.setOrderStatus(OrderStatus.DELIVERED);
		return orderRepo.save(order);
		
	}

}
