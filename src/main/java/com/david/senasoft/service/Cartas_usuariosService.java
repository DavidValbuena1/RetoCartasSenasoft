package com.david.senasoft.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.david.senasoft.model.Cartas_usuarios;
import com.david.senasoft.model.Usuario;

@Service
public interface Cartas_usuariosService {
	public List<Cartas_usuarios> findAll();
	public Cartas_usuarios findById(int id);
	public Cartas_usuarios save(Cartas_usuarios c);
	public Cartas_usuarios edit(Cartas_usuarios c);
	public Cartas_usuarios deleteById(int id);
	
	public List<Cartas_usuarios> actualizarLista(Iterable<Cartas_usuarios> cu);
	
	public List<Cartas_usuarios> repartirCartas(List<Usuario> u);
	

}
