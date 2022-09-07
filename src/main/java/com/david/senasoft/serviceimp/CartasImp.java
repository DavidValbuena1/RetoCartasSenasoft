package com.david.senasoft.serviceimp;

import java.util.ArrayList;
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
	
	public List<List<Carta>> repartirCartas(int Players){
		List<Carta> AllCards = new ArrayList<Carta>();
		List<List<Carta>> CardsDealt = new ArrayList<List<Carta>>();
		int numeros[]= new int[32];
		int i =0;
		numeros[i]=(int)(Math.random()*32);
		for(i=1;i<32;i++) {
			numeros[i]=(int) (Math.random()*32);
			for(int j=0;j<i;j++) {
				if(numeros[i]==numeros[j]) {
					i--;
				}
			}
		}
		for(int k=0;k<32;k++) {
			System.out.println((k+1)+"---"+numeros[k]);
		}
		return CardsDealt;
	}
	
	
}
