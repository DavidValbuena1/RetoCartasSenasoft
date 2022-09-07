package com.david.senasoft.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.senasoft.model.JugadorPartida;
import com.david.senasoft.repository.JugadorPartidaRepository;
import com.david.senasoft.service.JugadorPartidaService;

@Component
public class JugadorPartidaImp implements JugadorPartidaService {

	@Autowired(required=true)
	private JugadorPartidaRepository repositorio;
	
	@Override
	public List<JugadorPartida> listaJugadores(int id) {
		return repositorio.jugadores(id);
	}

	@Override
	public JugadorPartida enviarJugador(JugadorPartida jp) {
		return repositorio.save(jp);
	}

}
