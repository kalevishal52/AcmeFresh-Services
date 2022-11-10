package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.InstallationOrdersExeption;
import com.app.exception.NFTException;
import com.app.exception.PlantException;
import com.app.exception.PolyHouseTypeException;
import com.app.model.dto.InstallationDTO;
import com.app.model.dto.InstallationOrdersDTO;
import com.app.service.InstallationOrdersService;

@RestController
@RequestMapping("/acmefresh")
public class InstallationOrderController {

	@Autowired
	private InstallationOrdersService ordersService;
	
	@PostMapping("/install/order")
	public ResponseEntity<InstallationOrdersDTO> addInstallationOrderHandler(@RequestBody InstallationDTO installationDTO) throws InstallationOrdersExeption, PlantException, PolyHouseTypeException, NFTException {
		
	    InstallationOrdersDTO registerOrder = ordersService.addInstallationOrder(installationDTO);
	    
	    return new ResponseEntity<InstallationOrdersDTO>(registerOrder,HttpStatus.CREATED) ;
	}
	
}
