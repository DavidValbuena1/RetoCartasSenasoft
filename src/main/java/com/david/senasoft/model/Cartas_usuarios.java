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
@Table(name="cartas_usuarios")
public class Cartas_usuarios implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5156329628756403791L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="Carta_idcarta")
	private Carta Carta;
	
	@ManyToOne
	@JoinColumn(name="usuario_idusuario")
	private Usuario Usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Carta getCarta() {
		return Carta;
	}

	public void setCarta(Carta carta) {
		Carta = carta;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Cartas_usuarios [id=" + id + ", Usuario=" + Usuario + "]";
	}

	
	
}
