package com.meruvia.facturation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meruvia.facturation.model.Product;
import com.meruvia.facturation.repository.ProductRepository;

@Controller
@RequestMapping(path="/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepo;
	
	@PutMapping(path="/create")
	@ResponseBody
	public String addProduct(@Valid @RequestBody Product product) {
		
		productRepo.save(product);
		return "Producto registrado";
	}
	
	@GetMapping(path="/all")
	@ResponseBody
	public Iterable<Product> getAllProducts(){
		return productRepo.findAll();
	}
}
