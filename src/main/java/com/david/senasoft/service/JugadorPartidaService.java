package com.david.senasoft.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.david.senasoft.model.JugadorPartida;

@Service
public interface JugadorPartidaService {
	
	public List<JugadorPartida> listaJugadores(int id);
	public JugadorPartida enviarJugador(JugadorPartida jp);
}
