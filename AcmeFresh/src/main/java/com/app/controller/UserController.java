package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.UserException;
import com.app.model.dto.UserDTO;
import com.app.service.UserService;

@RestController
@RequestMapping("/acmefresh")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/users/")
	public ResponseEntity<UserDTO> registerUserHandler(@RequestBody UserDTO userDTO) throws UserException {
		
		UserDTO registerUser = userService.registerUser(userDTO) ;
		
		return new ResponseEntity<UserDTO>(userDTO,HttpStatus.CREATED) ;
	}
	
}
