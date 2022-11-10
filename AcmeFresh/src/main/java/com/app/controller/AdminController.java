package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.NFTException;
import com.app.exception.PolyHouseTypeException;
import com.app.model.NutrientFilmTechnique;
import com.app.model.PolyHouseType;
import com.app.service.NFTService;
import com.app.service.PolyHouseTypeService;

@RestController
@RequestMapping("/acmefresh/admin")
public class AdminController {

	@Autowired
	private NFTService nftService;
	
	@Autowired
	private PolyHouseTypeService polyHouseService;
	

	
	@PostMapping("/polyhouses/")
	public ResponseEntity<PolyHouseType> addPolyHouseHandler(@RequestBody PolyHouseType houseType) throws PolyHouseTypeException {
		
		PolyHouseType savedPolyHouse = polyHouseService.addPolyHouseType(houseType);
		
		return new ResponseEntity<PolyHouseType>(savedPolyHouse,HttpStatus.CREATED) ;
		
	}
	
	@PatchMapping("/polyhouses/update")
	public ResponseEntity<PolyHouseType> updatePolyHouseRateHandler(@RequestParam("polyHouseId") Integer polyHouseId,
																    @RequestParam("updatedPrice") Double updatedPrice) throws PolyHouseTypeException {
		
		PolyHouseType updatedPolyHouse = polyHouseService.updatePriceofPolyHouse(polyHouseId, updatedPrice);
		
		return new ResponseEntity<PolyHouseType>(updatedPolyHouse,HttpStatus.CREATED) ;
		
	}
	
	@GetMapping("/polyhouses/") 
	public ResponseEntity<List<PolyHouseType>> getAllPolyHouses() throws PolyHouseTypeException {
		
		List<PolyHouseType> list = polyHouseService.getAllPolyHouses();
		
		return new ResponseEntity<List<PolyHouseType>>(list,HttpStatus.OK);
	}
	
	@PostMapping("/nfts/")
	public ResponseEntity<NutrientFilmTechnique> addNFTHandler(@RequestBody NutrientFilmTechnique nft) throws NFTException {
		
		NutrientFilmTechnique savedNFT = nftService.addNFT(nft);
		
		return new ResponseEntity<NutrientFilmTechnique>(savedNFT,HttpStatus.CREATED) ;
	}
	
	@PatchMapping("/nfts/update")
	public ResponseEntity<NutrientFilmTechnique> updateNFTRateHandler(@RequestParam("nftId") Integer nftId,
																      @RequestParam("updatedPrice") Double updatedPrice) throws NFTException {
		
		NutrientFilmTechnique updatedNFT = nftService.updateNFTPrice(nftId, updatedPrice);
		
		return new ResponseEntity<NutrientFilmTechnique>(updatedNFT,HttpStatus.CREATED) ;
	}
	
	@GetMapping("/nfts/")
	public ResponseEntity<List<NutrientFilmTechnique>> getAllNFT(){
		
		List<NutrientFilmTechnique> list = nftService.getAllNFT();
		
		return new ResponseEntity<List<NutrientFilmTechnique>>(list,HttpStatus.OK);
	}
	

	
}









