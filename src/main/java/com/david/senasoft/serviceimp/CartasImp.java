package com.david.senasoft.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.senasoft.model.Carta;
import com.david.senasoft.repository.CartaRepository;
import com.david.senasoft.service.CartaService;

@Component
public class CartasImp implements CartaService{
	
	@Autowired(required=true)
	private CartaRepository repositorio;

	@Override
	public List<Carta> findAll() {
		return repositorio.findAll();
	}
	

	@Override
	public Carta findById(int id) {
		return repositorio.findById(id);
	}
	
	
}
