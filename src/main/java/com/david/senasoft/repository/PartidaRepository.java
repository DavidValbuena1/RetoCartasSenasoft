package com.david.senasoft.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.david.senasoft.model.Partida;

public interface PartidaRepository extends Repository<Partida, Integer> {
	
	public List<Partida> findAll();
	public Partida findById(int id);
	public Partida save(Partida P);
	public Partida deleteById(int id);
}
