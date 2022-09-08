package com.david.senasoft.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.senasoft.model.Carta;
import com.david.senasoft.model.Cartas_usuarios;
import com.david.senasoft.model.Usuario;
import com.david.senasoft.repository.Cartas_usuariosRepository;
import com.david.senasoft.service.Cartas_usuariosService;

@Component
public class Cartas_usuariosImp implements Cartas_usuariosService {

	@Autowired(required = true)
	private Cartas_usuariosRepository repositorio;

	@Autowired(required = true)
	private CartasImp serviceCard;

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

	public List<Cartas_usuarios> repartirCartas(List<Usuario> u) {
		List<Cartas_usuarios> CardsDealt = new ArrayList<Cartas_usuarios>();
		Carta card = new Carta();
		
		repositorio.deleteAll();

		int i = 1;
		int rango = 32;
		int cantidadJugadores = u.size();
		int division = 32 / cantidadJugadores;
		int numeros[] = new int[rango];
		int residuo = 32%cantidadJugadores;
		int numeros2[]=new int[rango-residuo+1];
		for (i = 0; i < rango; i++) {
			numeros[i] = ((int) (Math.random() * 32)) + 1;
			for (int j = 0; j < i; j++) {
				if (numeros[i] == numeros[j]) {
					i--;
				}
			}
		}
		int cont = 0;
		
		for (Usuario us : u) {
			for (int k = 0; k <= division-1; k++) {
				Cartas_usuarios cartas = new Cartas_usuarios();
				cont++;
				if(cont<=division*cantidadJugadores) {
					numeros2[cont]=numeros[cont];
					System.out.println(numeros2[cont]);
					card = serviceCard.findById(numeros2[cont]);
					System.out.println(card);
					cartas.setId(cont);
					cartas.setCarta(card);
					cartas.setUsuario(us);
					CardsDealt.add(cartas);
				}
			}
		}
		repositorio.saveAll(CardsDealt);
		return CardsDealt;
	}

	@Override
	public List<Cartas_usuarios> actualizarLista(Iterable<Cartas_usuarios> cu) {
		return repositorio.saveAll(cu);
	}
	

}
