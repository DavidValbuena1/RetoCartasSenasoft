package com.david.senasoft.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.david.senasoft.model.Cartas_usuarios;

@Service
public interface Cartas_usuariosService {
	public List<Cartas_usuarios> findAll();
	public Cartas_usuarios findById(int id);
	public Cartas_usuarios save(Cartas_usuarios c);
	public Cartas_usuarios edit(Cartas_usuarios c);
	public Cartas_usuarios deleteById(int id);
}
