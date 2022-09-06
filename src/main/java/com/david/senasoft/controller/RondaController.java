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

import com.david.senasoft.model.Ronda;
import com.david.senasoft.service.RondaService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping({"/Senasoft/Ronda"})
public class RondaController {
	@Autowired(required=true)
	private RondaService service;
	
	@GetMapping(path= {"/listar"})
	public List<Ronda> listar(){
		return service.findAll();
	}
	
	@GetMapping(path= {"/listarId/{id}"})
	public Ronda listarId(@PathVariable("id") int id) {
		return service.findById(id);
	}
	
	@PostMapping(path= {"/agregar"})
	public Ronda agregar(@RequestBody Ronda cu) {
		return service.save(cu);
	}
	
	@PutMapping(path = {"/editar/{id}"})
	public Ronda editar(@PathVariable("id") int id, @RequestBody Ronda cu) {
		cu.setId(id);
		return service.edit(cu);
	}
	
	@DeleteMapping(path= {"/borrar/{id}"})
	public Ronda eliminar(@PathVariable("id") int id) {
		return service.deleteById(id);
	}
}
