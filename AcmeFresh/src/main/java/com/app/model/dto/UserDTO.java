package com.app.model.dto;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import com.app.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private Integer userId;
	
	private String firstName;
	private String lastName;
	private String eamil;
	private String mobileNumber;
	private String password;
	private String role;
	
	private Address address;
	
}
