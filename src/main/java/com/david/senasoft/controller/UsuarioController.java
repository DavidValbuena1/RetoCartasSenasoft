package com.david.senasoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.david.senasoft.model.Usuario;
import com.david.senasoft.service.UsuarioService;

public class UsuarioController {
	
	@Autowired(required=true)
	private UsuarioService service;
	
	@GetMapping(path= {"/listar"})
	public List<Usuario> listar(){
		return service.findAll();
	}
	
	@GetMapping(path= {"/listarId/{id}"})
	public Usuario listarId(@PathVariable("id") int id) {
		return service.findByID(id);
	}
	
	@PostMapping(path= {"/agregar"})
	public Usuario agregar(@RequestBody Usuario cu) {
		return service.save(cu);
	}
	
	@PutMapping(path = {"/editar/{id}"})
	public Usuario editar(@PathVariable("id") int id, @RequestBody Usuario cu) {
		cu.setIdusuario(id);
		return service.edit(cu);
	}
	
	@DeleteMapping(path= {"/borrar/{id}"})
	public Usuario eliminar(@PathVariable("id") int id) {
		return service.deleteById(id);
	}
}
