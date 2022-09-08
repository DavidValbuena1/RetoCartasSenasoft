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
@Table(name="usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 7798580345927299664L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuario;
	
	@Column
	private String nombre;
	
	@Column
	private String Tipousuario;
	
	@Column
	private String Resultado;
	
	@ManyToOne
	@JoinColumn(name="partida_idpartida")
	private Partida partida;

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoUsuario() {
		return Tipousuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		Tipousuario = tipoUsuario;
	}

	public String getResultado() {
		return Resultado;
	}

	public void setResultado(String resultado) {
		Resultado = resultado;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", nombre=" + nombre + ", TipoUsuario=" + Tipousuario
				+ ", Resultado=" + Resultado + ", partida=" + partida + "]";
	}
	
	
}
