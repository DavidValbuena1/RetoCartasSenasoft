package com.david.senasoft.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="jugador_partida")
public class JugadorPartida implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="idpartida")
	private Partida partida;
	
	@ManyToOne
	@JoinColumn(name="idjugador")
	private Usuario jugador;

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public Usuario getJugador() {
		return jugador;
	}

	public void setJugador(Usuario jugador) {
		this.jugador = jugador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "JugadorPartida [id=" + id + ", partida=" + partida + ", jugador=" + jugador + "]";
	}

	
	
	
}
