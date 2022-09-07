package com.david.senasoft.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.david.senasoft.model.Cartas_usuarios;
import com.david.senasoft.model.Partida;


@Service
public interface PartidaService {
	public List<Partida> findAll();
	public Partida save(Partida p);
	public Partida edit(Partida p);
	public Partida deleteById(int id);
	public Partida findById(int id);
	
	public void finalizarPartida(List<Cartas_usuarios> cu,Partida p);
}
