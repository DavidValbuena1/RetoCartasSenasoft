package com.david.senasoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.david.senasoft.model.JugadorPartida;

public interface JugadorPartidaRepository extends Repository<JugadorPartida, Integer> {
	
	@Query("SELECT jp FROM JugadorPartida jp WHERE jp.partida.idpartida = ?1")
	public List<JugadorPartida> jugadores(int id);
	
	public JugadorPartida save(JugadorPartida jp);
}
