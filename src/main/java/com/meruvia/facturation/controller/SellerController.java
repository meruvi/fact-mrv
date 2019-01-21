package com.meruvia.facturation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meruvia.facturation.model.Seller;
import com.meruvia.facturation.repository.SellerRepository;

@Controller
@RequestMapping(path="/seller")
public class SellerController {

	@Autowired
	private SellerRepository sellerRepo;
	
	@PutMapping(path="/create")
	@ResponseBody
	public String addSeller(@Valid @RequestBody Seller seller) {
		
		sellerRepo.save(seller);
		return "Seller creado";
	}
	
	@GetMapping(path="/all")
	@ResponseBody
	public Iterable<Seller> getAllSeller(){
		
		return sellerRepo.findAll();
	}
}
