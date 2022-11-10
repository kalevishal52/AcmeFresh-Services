package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.InstallationOrdersExeption;
import com.app.exception.NFTException;
import com.app.model.NutrientFilmTechnique;
import com.app.repository.NFTReop;

@Service
public class NFTServiceImpl implements NFTService {

	@Autowired
	private NFTReop nftReop;

	@Override
	public NutrientFilmTechnique addNFT(NutrientFilmTechnique nft) throws NFTException {
		
		return nftReop.save(nft);
	}

	@Override
	public NutrientFilmTechnique updateNFTPrice(Integer nftId, Double price) throws NFTException {
		
		NutrientFilmTechnique currentNFT = nftReop.findById(nftId).orElseThrow(() -> new NFTException("Invalid NFT id: "+nftId)) ;
		
		currentNFT.setNftRate(price);
		
		return nftReop.save(currentNFT);
	}

	@Override
	public NutrientFilmTechnique getNFTByID(Integer id) throws NFTException {
		
		return nftReop.findById(id).orElseThrow(()-> new NFTException("Invalid NFTId Provided: "+id)) ;
	}

	@Override
	public List<NutrientFilmTechnique> getAllNFT() {

		return nftReop.findAll();
	}
	
	
	
}
