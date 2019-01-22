package com.meruvia.facturation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.meruvia.facturation.model.Factura;
import com.meruvia.facturation.repository.FacturaRepository;

@Controller
@RequestMapping(path="/factura")
public class FacturaController {

	@Autowired
	private FacturaRepository facturaRepo;
	
	@PutMapping(path="/create")
	@ResponseBody
	public String addFactura(@Valid @RequestBody Factura factura) {
		
		facturaRepo.save(factura);
		return "Factura creada";
	}
	
	@GetMapping(path="/all")
	@ResponseBody
	public List<Factura> getAllFactura(){
		
		/*ModelAndView mav = new ModelAndView("template");
		
		List<Factura> facts = facturaRepo.findAll();
		
		mav.addObject("facts", facts);
		
		return mav;*/
		
		return facturaRepo.findAll();
	}
}
