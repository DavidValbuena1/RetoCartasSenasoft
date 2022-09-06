package com.david.senasoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ronda")
public class Ronda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7597514827191099127L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int num;
	
	@Column
	private String codcartaganadora;
	
	@ManyToOne
	@JoinColumn(name="idpartida")
	private Partida partida;
	
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCodcartaganadora() {
		return codcartaganadora;
	}

	public void setCodcartaganadora(String codcartaganadora) {
		this.codcartaganadora = codcartaganadora;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Ronda [id=" + id + ", num=" + num + ", codcartaganadora=" + codcartaganadora + ", partida=" + partida
				+ ", usuario=" + usuario + "]";
	}
	
	
	
}
