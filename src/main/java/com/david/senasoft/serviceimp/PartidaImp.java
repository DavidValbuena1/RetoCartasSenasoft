package com.david.senasoft.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.senasoft.model.Partida;
import com.david.senasoft.repository.PartidaRepository;
import com.david.senasoft.service.PartidaService;

@Component
public class PartidaImp implements PartidaService {

	@Autowired(required=true)
	private PartidaRepository repositorio;
	
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

}
