package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.app.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private OrderStatus orderStatus;
	private Integer clintProduceId;
	private Integer plantId;
	private String plantName;
	private Integer quantity;
	private Double totalOrderAmount;
	
	@OneToOne
	private User buyer;

	@OneToOne
	private User seller ;

}
