package com.david.senasoft.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.david.senasoft.model.Cartas_usuarios;

public interface Cartas_usuariosRepository extends Repository<Cartas_usuarios, Integer> {
	
	public List<Cartas_usuarios> findAll();
	public Cartas_usuarios findById(int id);
	public Cartas_usuarios save(Cartas_usuarios c);
	public Cartas_usuarios deleteById(int id);
}
