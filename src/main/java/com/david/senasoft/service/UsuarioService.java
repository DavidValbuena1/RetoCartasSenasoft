package com.david.senasoft.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.david.senasoft.model.Usuario;

@Service
public interface UsuarioService {
	
	public List<Usuario> findAll();
	public Usuario findByID(int id);
	public Usuario save(Usuario u);
	public Usuario edit(Usuario u);
	public Usuario deleteById(int id);
}
