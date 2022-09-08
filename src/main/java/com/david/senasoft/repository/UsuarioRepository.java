package com.david.senasoft.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.david.senasoft.model.Usuario;

public interface UsuarioRepository extends Repository<Usuario, Integer> {
	
	public List<Usuario> findAll();
	public Usuario findById(int id);
	public Usuario deleteById(int id);
	public Usuario save(Usuario u);
}
