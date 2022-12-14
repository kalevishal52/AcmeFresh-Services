package com.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	
	private Integer plantId;
	private Integer quantity;
	private Integer buyerUserId;

	private Integer clintProduceDetailsId ;
	
}
