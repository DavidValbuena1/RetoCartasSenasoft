package com.david.senasoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.senasoft.model.JugadorPartida;
import com.david.senasoft.service.JugadorPartidaService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping({"/Senasoft/JugadorPartida"})
public class JugadorPartidaController {
	
	@Autowired(required=true)
	private JugadorPartidaService service;
	
	@GetMapping(path= {"/listar/{id}"})
	public List<JugadorPartida> listaJugadores(@PathVariable("id") int id){
		return service.listaJugadores(id);
	}
	
	@PostMapping(path= {"/agregar"})
	public JugadorPartida agregarJugador(@RequestBody JugadorPartida jp) {
		return service.enviarJugador(jp);
	}

	
}
