package com.david.senasoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.senasoft.model.Cartas_usuarios;
import com.david.senasoft.model.Partida;
import com.david.senasoft.service.PartidaService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping({"/Senasoft/Partida"})
public class PartidaController {
	@Autowired(required=true)
	private PartidaService service;
	
	@GetMapping(path= {"/listar"})
	public List<Partida> listar(){
		return service.findAll();
	}
	
	@GetMapping(path= {"/listarId/{id}"})
	public Partida listarId(@PathVariable("id") int id) {
		return service.findById(id);
	}
	
	@PostMapping(path= {"/agregar"})
	public Partida agregar(@RequestBody Partida cu) {
		return service.save(cu);
	}
	
	@PutMapping(path = {"/editar/{id}"})
	public Partida editar(@PathVariable("id") int id, @RequestBody Partida cu) {
		cu.setIdpartida(id);
		return service.edit(cu);
	}
	
	@DeleteMapping(path= {"/borrar/{id}"})
	public Partida eliminar(@PathVariable("id") int id) {
		return service.deleteById(id);
	}
	
	@PostMapping(path= {"/finalizarPartida"})
	public void finalizar(@RequestBody List<Cartas_usuarios> cu, @RequestBody Partida p) {
		service.finalizarPartida(cu, p);
	}
}
