package com.meruvia.facturation.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meruvia.facturation.model.Client;
import com.meruvia.facturation.repository.ClienteRepository;

@Controller
//@RequestMapping(path="/client")
public class ClienteController {

	@Autowired
	private ClienteRepository clientRepo;
	
	@PutMapping(path="/client")
	@ResponseBody
	public String addCliente(@Valid @RequestBody Client cliTemp) {
		clientRepo.save(cliTemp);
		return "Cliente agregado";
	}
	
	@GetMapping(path="/client")
	@ResponseBody
	public Iterable<Client> getAllClients(){
		
		return clientRepo.findAll(); 
	}
	
	@PostMapping(path="/client")
	@ResponseBody
	public String updateCliente(@Valid @RequestBody Client cliTemp) {
		clientRepo.save(cliTemp);
		return "Cliente modificado";
	}
	
	@DeleteMapping(path="/client/{id}")
	@ResponseBody
	public String deleteCliente(@PathVariable long id) {
		
		Client cli = clientRepo.findById(id);
		
		if(cli == null) {
			return "El registro no existe";
		}
		
		clientRepo.deleteById(id);
		return "Cliente Eliminado";
	}
	
}
