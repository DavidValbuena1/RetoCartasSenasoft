package com.david.senasoft.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.senasoft.model.Cartas_usuarios;
import com.david.senasoft.repository.Cartas_usuariosRepository;
import com.david.senasoft.service.Cartas_usuariosService;

@Component
public class Cartas_usuariosImp implements Cartas_usuariosService{

	@Autowired(required=true)
	private Cartas_usuariosRepository repositorio;

	@Override
	public List<Cartas_usuarios> findAll() {
		return repositorio.findAll();
	}

	@Override
	public Cartas_usuarios findById(int id) {
		return repositorio.findById(id);
	}

	@Override
	public Cartas_usuarios save(Cartas_usuarios c) {
		return repositorio.save(c);
	}

	@Override
	public Cartas_usuarios edit(Cartas_usuarios c) {
		return repositorio.save(c);
	}

	@Override
	public Cartas_usuarios deleteById(int id) {
		return repositorio.deleteById(id);
	}
	 

}
