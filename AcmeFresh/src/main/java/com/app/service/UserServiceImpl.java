package com.app.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.exception.UserException;
import com.app.model.User;
import com.app.model.dto.UserDTO;
import com.app.repository.UserReop;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserReop userRepo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDTO registerUser(UserDTO userDTO) throws UserException {
		
		User user = userRepo.findByMobileNumber(userDTO.getMobileNumber());
		
		if(user != null) throw new UserException("User Already Registred With mobile Number: "+userDTO.getMobileNumber()) ; 
		
		userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
		userDTO.setRole("ROLE_"+userDTO.getRole());
		
		user = new User();
		BeanUtils.copyProperties(userDTO, user);
		
		user = userRepo.save(user) ;
		BeanUtils.copyProperties(user, userDTO);
		
		return userDTO;
	}

	@Override
	public User getUserById(Integer id) throws UserException {
		
		return userRepo.findById(id).orElseThrow(()-> new UserException("INvalid User Id " + id));
	}
	
	
	
}
