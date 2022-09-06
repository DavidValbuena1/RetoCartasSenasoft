package com.david.senasoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Table(name="partida")
@Entity
public class Partida implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8586477987682946849L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpartida;
	
	@Column
	private String Codigo;
	
	@Column
	private byte Estado;
	
	@Column
	private int Rondas;
	
	@Column
	private String Resultado;

	public int getIdpartida() {
		return idpartida;
	}

	public void setIdpartida(int idpartida) {
		this.idpartida = idpartida;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public byte getEstado() {
		return Estado;
	}

	public void setEstado(byte estado) {
		Estado = estado;
	}

	public int getRondas() {
		return Rondas;
	}

	public void setRondas(int rondas) {
		Rondas = rondas;
	}

	public String getResultado() {
		return Resultado;
	}

	public void setResultado(String resultado) {
		Resultado = resultado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Partida [idpartida=" + idpartida + ", Codigo=" + Codigo + ", Estado=" + Estado + ", Rondas=" + Rondas
				+ ", Resultado=" + Resultado + "]";
	}
	
	

}
