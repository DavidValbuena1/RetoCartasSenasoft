package com.david.senasoft.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.senasoft.model.Ronda;
import com.david.senasoft.repository.RondaRepository;
import com.david.senasoft.service.RondaService;

@Component
public class RondaImp implements RondaService{
	
	@Autowired(required=true)
	private RondaRepository repositorio;

	@Override
	public List<Ronda> findAll() {
		return repositorio.findAll();
	}

	@Override
	public Ronda findById(int id) {
		return repositorio.findById(id);
	}

	@Override
	public Ronda save(Ronda r) {
		return repositorio.save(r);
	}

	@Override
	public Ronda edit(Ronda r) {
		return repositorio.save(r);
	}

	@Override
	public Ronda deleteById(int id) {
		return repositorio.deleteById(id);
	}
	
	@Override
	public String finalizarRonda(Ronda r) {
		repositorio.save(r);
		String CodGanador = r.getCodcartaganadora();
		return CodGanador;
	}

	@Override
	public List<Ronda> rondas(int id) {
		return repositorio.rondas(id);
	}
	
}
