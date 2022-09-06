package com.david.senasoft.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface PartidaRepository extends Repository<PartidaRepository, Integer> {
	
	public List<PartidaRepository> findAll();
	public PartidaRepository findById(int id);
	public PartidaRepository save(PartidaRepository P);
	public PartidaRepository deleteById(int id);
}
