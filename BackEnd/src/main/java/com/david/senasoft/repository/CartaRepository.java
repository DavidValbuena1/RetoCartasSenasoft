package com.david.senasoft.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.david.senasoft.model.Carta;

public interface CartaRepository extends Repository<Carta, Integer>{
	
	public List<Carta> findAll();
	public Carta findById(int id);
}
