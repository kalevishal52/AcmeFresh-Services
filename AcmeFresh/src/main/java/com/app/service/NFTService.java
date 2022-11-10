package com.app.service;

import java.util.List;

import com.app.exception.NFTException;
import com.app.model.NutrientFilmTechnique;

public interface NFTService {

	public NutrientFilmTechnique addNFT(NutrientFilmTechnique nft) throws NFTException;
	
	public NutrientFilmTechnique updateNFTPrice(Integer nftId,Double price) throws NFTException;
	
	public NutrientFilmTechnique getNFTByID(Integer id) throws NFTException;
	
	public List<NutrientFilmTechnique> getAllNFT() ;
}
