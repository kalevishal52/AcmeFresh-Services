package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.enums.BillStatus;
import com.app.exception.InstallationOrdersExeption;
import com.app.exception.NFTException;
import com.app.exception.PlantException;
import com.app.exception.PolyHouseTypeException;
import com.app.model.Address;
import com.app.model.BillingDetails;
import com.app.model.InstallationOrders;
import com.app.model.NutrientFilmTechnique;
import com.app.model.Plant;
import com.app.model.PolyHouseType;
import com.app.model.User;
import com.app.model.dto.InstallationDTO;
import com.app.model.dto.InstallationOrdersDTO;
import com.app.repository.AddressReop;
import com.app.repository.BillingDetailsReop;
import com.app.repository.InstallationOrdersRepo;
import com.app.repository.NFTReop;
import com.app.repository.PlantRepo;
import com.app.repository.PolyHouseTypeReop;
import com.app.repository.UserReop;

@Service
public class InstallationOrdersServiceImpl implements InstallationOrdersService {

	@Autowired
	private InstallationOrdersRepo installationRepo;
	
	@Autowired
	private PolyHouseTypeReop polyHouseRepo;
	
	@Autowired
	private NFTReop nftReop;
	
	@Autowired 
	private UserReop userReop;
	
	@Autowired
	private PlantService plantService;
	
	@Autowired
	private PolyHouseTypeService polyHouseService;
	
	@Autowired
	private NFTService nftService;
	
	@Autowired 
	private BillingDetailsReop billingRepo;
	
	@Autowired
	private AddressReop addressReop;
	
	@Override
	public InstallationOrdersDTO addInstallationOrder(InstallationDTO infoDTO) throws InstallationOrdersExeption, PlantException, PolyHouseTypeException, NFTException {
		
		User user = userReop.findById(infoDTO.getUserId()).orElseThrow(()-> new InstallationOrdersExeption("Invalid UserId Provided: "+infoDTO.getUserId())) ;
		
		PolyHouseType polyHouse = polyHouseService.getPolyHouseById(infoDTO.getPolyHouseTypeId()) ;
		
		NutrientFilmTechnique nft = nftService.getNFTByID(infoDTO.getNftId()) ;
		
		List<Integer> plantIds = new ArrayList<>(infoDTO.getPlantIdWithQuantity().keySet()) ;
		List<Plant> plantsList = plantService.getPlantsListByIds(plantIds);
		
		
		StringBuilder billDesc = new StringBuilder(); 
		
		Double polyHouseTotalAmount = infoDTO.getRequireInAreaPerSqMtr() * polyHouse.getRatePerSqMeter();
		Double nftTotalAmount = ( infoDTO.getRequireInAreaPerSqMtr() * 86 * 0.01) * nft.getNftRate() * nft.getChannelSizeInMtrPerSqMtr();
		
		Double plantsTotal = 0.0;
		Map<Integer,Integer> hm = infoDTO.getPlantIdWithQuantity();
		
		for(Plant plant : plantsList) {
			
			Integer pId = plant.getPlantId();
			if(hm.containsKey(pId)) {
				
				plantsTotal += (plant.getSeedReatePerUnit() * hm.get(pId)) ;
				
				billDesc.append("Plants name "+plant.getName() +" seedRatePerUnit " +plant.getSeedReatePerUnit()
					            +" TotalAmountFor this plnat with quantity "+ hm.get(pId) +" = " +(plant.getSeedReatePerUnit() * hm.get(pId)) )  ;
				billDesc.append("/n"); 
			}
			
		}
		billDesc.append("Total Amount for PloyHouse: "+polyHouse.getPolyHouseTypeId() 
						+" => Area "+ infoDTO.getRequireInAreaPerSqMtr() + " * "+ polyHouse.getRatePerSqMeter() +" = " + infoDTO.getRequireInAreaPerSqMtr() * polyHouse.getRatePerSqMeter() ) ;
		billDesc.append("/n"); 

		billDesc.append("Total Amount for NFT: "+ nft.getNftId() 
						+" => 86% of Area  "+ ( infoDTO.getRequireInAreaPerSqMtr() * 86 * 0.01) + " * "+  nft.getNftRate() + " * " + nft.getChannelSizeInMtrPerSqMtr() +
						" = " +( infoDTO.getRequireInAreaPerSqMtr() * 86 * 0.01) * nft.getNftRate() * nft.getChannelSizeInMtrPerSqMtr()) ;
		billDesc.append("/n"); 
		
		Double totalBill = polyHouseTotalAmount + nftTotalAmount + plantsTotal ;
		
		Address address = addressReop.save(infoDTO.getAddress());
		
		InstallationOrders installationOrders = new InstallationOrders();
		installationOrders.setBillDesc(billDesc.toString());
		installationOrders.setOrderAddress(address);
		installationOrders.setPlants(plantsList);
		installationOrders.setPolyHouseType(polyHouse);
		installationOrders.setRequireInAreaPerSqMtr(infoDTO.getRequireInAreaPerSqMtr());
		installationOrders.setTechnique(nft);
		installationOrders.setUser(user);
		installationOrders.setTotalBillAmount(totalBill);
		
		installationOrders = installationRepo.save(installationOrders);
		
		BillingDetails billingDetails = new BillingDetails(BillStatus.PENDING, totalBill, billDesc.toString(), installationOrders.getOrderId(), user.getUserId()) ;
		billingRepo.save(billingDetails);
		
		InstallationOrdersDTO orderDTO = new InstallationOrdersDTO();
		BeanUtils.copyProperties(installationOrders, orderDTO);
		
		return orderDTO;
	}

}












