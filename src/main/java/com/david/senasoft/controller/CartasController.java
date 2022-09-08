package com.david.senasoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.senasoft.model.Carta;
import com.david.senasoft.service.CartaService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping({"/Senasoft/Carta"})
public class CartasController {
	
	@Autowired(required=true)
	private CartaService service;
	
	@GetMapping(path= {"/listar"})
	public List<Carta> listar(){
		return service.findAll();
	}
}
