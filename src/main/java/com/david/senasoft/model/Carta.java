package com.david.senasoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carta")
public class Carta implements Serializable {
	
	private static final long serialVersionUID = -3898470412992503352L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcarta;
	
	@Column
	private String Marca;
	
	@Column
	private String Cilindraje;
	
	@Column
	private String Potencia;
	
	
	@Column
	private String Peso;
	
	@Column
	private String Codigo;
	
	@Column
	private String Imagen;

	public int getIdcarta() {
		return idcarta;
	}

	public void setIdcarta(int idcarta) {
		this.idcarta = idcarta;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getCilindraje() {
		return Cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		Cilindraje = cilindraje;
	}

	public String getPotencia() {
		return Potencia;
	}

	public void setPotencia(String potencia) {
		Potencia = potencia;
	}


	public String getPeso() {
		return Peso;
	}

	public void setPeso(String peso) {
		Peso = peso;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public String getImagen() {
		return Imagen;
	}

	public void setImagen(String imagen) {
		Imagen = imagen;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Carta [idcarta=" + idcarta + ", Marca=" + Marca + ", Cilindraje=" + Cilindraje + ", Potencia="
				+ Potencia + ", Peso=" + Peso + ", Codigo=" + Codigo + ", Imagen="
				+ Imagen + "]";
	}
	
	
}
