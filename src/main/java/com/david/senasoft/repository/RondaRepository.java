package com.david.senasoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.david.senasoft.model.Ronda;

public interface RondaRepository extends Repository<Ronda, Integer> {
	public List<Ronda> findAll();
	public Ronda findById(int id);
	public Ronda save(Ronda r);
	public Ronda deleteById(int id);
	
	@Query("SELECT r FROM Ronda r WHERE r.partida.idpartida=?1")
	public List<Ronda> rondas(int id);
}
