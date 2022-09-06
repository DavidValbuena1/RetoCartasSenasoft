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
import com.david.senasoft.service.Cartas_usuariosService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping({"/Senasoft/CartasUsuarios"})
public class Cartas_usuariosController {
	@Autowired(required=true)
	private Cartas_usuariosService service;
	
	@GetMapping(path= {"/listar"})
	public List<Cartas_usuarios> listar(){
		return service.findAll();
	}
	
	@GetMapping(path= {"/listarId/{id}"})
	public Cartas_usuarios listarId(@PathVariable("id") int id) {
		return service.findById(id);
	}
	
	@PostMapping(path= {"/agregar"})
	public Cartas_usuarios agregar(@RequestBody Cartas_usuarios cu) {
		return service.save(cu);
	}
	
	@PutMapping(path = {"/editar/{id}"})
	public Cartas_usuarios editar(@PathVariable("id") int id, @RequestBody Cartas_usuarios cu) {
		cu.setId(id);
		return service.edit(cu);
	}
	
	@DeleteMapping(path= {"/borrar/{id}"})
	public Cartas_usuarios eliminar(@PathVariable("id") int id) {
		return service.deleteById(id);
	}
}
