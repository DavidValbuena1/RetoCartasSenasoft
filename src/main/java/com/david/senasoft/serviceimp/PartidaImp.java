package com.david.senasoft.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.senasoft.model.Cartas_usuarios;
import com.david.senasoft.model.Partida;
import com.david.senasoft.model.Ronda;
import com.david.senasoft.repository.Cartas_usuariosRepository;
import com.david.senasoft.repository.PartidaRepository;
import com.david.senasoft.repository.RondaRepository;
import com.david.senasoft.service.PartidaService;

@Component
public class PartidaImp implements PartidaService {

	@Autowired(required=true)
	private PartidaRepository repositorio;
	

	@Autowired(required=true)
	private Cartas_usuariosRepository repositorioCartasUsuarios;
	
	@Autowired(required=true)
	private RondaRepository repositorioRonda;
	
	@Override
	public List<Partida> findAll() {
		return repositorio.findAll();
	}

	@Override
	public Partida save(Partida p) {
		return repositorio.save(p);
	}

	@Override
	public Partida edit(Partida p) {
		return repositorio.save(p);
	}

	@Override
	public Partida deleteById(int id) {
		return repositorio.deleteById(id);
	}

	@Override
	public Partida findById(int id) {
		return repositorio.findById(id);
	}

	@Override
	public void finalizarPartida(List<Cartas_usuarios> cu,Partida p) {
		repositorioCartasUsuarios.saveAll(cu);
		List<Ronda> rondas = new ArrayList<>();
		rondas = repositorioRonda.rondas(p.getIdpartida());
		int cantidadRondas = rondas.size();
		p.setRondas(cantidadRondas);
		repositorio.save(p);
		
	}

}
