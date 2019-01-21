package com.meruvia.facturation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meruvia.facturation.model.Cliente;
import com.meruvia.facturation.repository.ClienteRepository;

@Controller
@RequestMapping(path="/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepo;
	
	@PostMapping(path="/agregar")
	@ResponseBody
	public String addCliente(@Valid @RequestBody Cliente cliTemp) {
		clienteRepo.save(cliTemp);
		return "Cliente agregado";
	}
	
}
