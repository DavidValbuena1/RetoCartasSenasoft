package com.david.senasoft.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.senasoft.model.Usuario;
import com.david.senasoft.repository.UsuarioRepository;
import com.david.senasoft.service.UsuarioService;

@Component
public class UsuarioImp implements UsuarioService {
	
	@Autowired(required=true)
	private UsuarioRepository repositorio;

	@Override
	public List<Usuario> findAll() {
		return repositorio.findAll();
	}

	@Override
	public Usuario findByID(int id) {
		return repositorio.findById(id);
	}

	@Override
	public Usuario save(Usuario u) {
		return repositorio.save(u);
	}

	@Override
	public Usuario edit(Usuario u) {
		return repositorio.save(u);
	}

	@Override
	public Usuario deleteById(int id) {
		return repositorio.deleteById(id);
	}
	
	
}
