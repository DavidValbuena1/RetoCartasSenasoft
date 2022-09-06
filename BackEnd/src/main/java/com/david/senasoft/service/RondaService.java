package com.david.senasoft.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.david.senasoft.model.Ronda;

@Service
public interface RondaService {
	public List<Ronda> findAll();
	public Ronda findById(int id);
	public Ronda save(Ronda r);
	public Ronda edit(Ronda r);
	public Ronda deleteById(int id);
}
