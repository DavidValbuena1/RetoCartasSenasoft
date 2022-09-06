package com.david.senasoft.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.david.senasoft.model.Carta;

@Service
public interface CartaService {
	
	public List<Carta> findAll();
}
