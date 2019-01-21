package com.meruvia.facturation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meruvia.facturation.model.Client;
import com.meruvia.facturation.repository.ClienteRepository;

@Controller
@RequestMapping(path="/client")
public class ClienteController {

	@Autowired
	private ClienteRepository clientRepo;
	
	@PutMapping(path="/create")
	@ResponseBody
	public String addCliente(@Valid @RequestBody Client cliTemp) {
		clientRepo.save(cliTemp);
		return "Cliente agregado";
	}
	
	@GetMapping(path="/all")
	@ResponseBody
	public Iterable<Client> getAllClients(){
		
		return clientRepo.findAll(); 
	}
	
}
