package com.david.senasoft;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.david.senasoft.model.Carta;


@SpringBootTest
class SenasoftApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void repartirCartas(){
		List<Carta> AllCards = new ArrayList<Carta>();
		List<List<Carta>> CardsDealt = new ArrayList<List<Carta>>();
		int numeros[]= new int[32];
		int i =1; int rango=32;
		for(i=1;i<rango;i++) {
			numeros[i]=((int)(Math.random()*32))+1;
			for(int j=1;j<i;j++) {
				if(numeros[i]==numeros[j]) {
					i--;
				}
			}
		}
		for(int k=0;k<rango;k++) {
			System.out.println((k)+"---"+numeros[k]);
		}
	}
}
