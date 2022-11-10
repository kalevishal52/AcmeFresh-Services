package com.app.service;

import com.app.exception.InstallationOrdersExeption;
import com.app.exception.NFTException;
import com.app.exception.PlantException;
import com.app.exception.PolyHouseTypeException;
import com.app.model.dto.InstallationDTO;
import com.app.model.dto.InstallationOrdersDTO;

public interface InstallationOrdersService {

	public InstallationOrdersDTO addInstallationOrder(InstallationDTO infoDTO) throws InstallationOrdersExeption, PlantException, PolyHouseTypeException, NFTException;
	
	
}
