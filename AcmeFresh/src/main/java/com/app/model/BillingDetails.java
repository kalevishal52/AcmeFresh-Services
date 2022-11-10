package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.app.enums.BillStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer billId;
	
	private BillStatus billStatus;
	private Double totalBillAmount;
	private String description;
	
	private Integer ordersId;
	
	private Integer userId;

	public BillingDetails(BillStatus billStatus, Double totalBillAmount, String description, Integer ordersId,
			Integer userId) {
		super();
		this.billStatus = billStatus;
		this.totalBillAmount = totalBillAmount;
		this.description = description;
		this.ordersId = ordersId;
		this.userId = userId;
	}
	
	
}
