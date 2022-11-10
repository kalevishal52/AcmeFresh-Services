package com.app.service;

import com.app.exception.UserException;
import com.app.model.User;
import com.app.model.dto.UserDTO;

public interface UserService {

	public UserDTO registerUser(UserDTO userDTO) throws UserException;
	
	public User getUserById(Integer id) throws UserException;
}
