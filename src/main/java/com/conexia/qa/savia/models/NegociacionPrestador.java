package com.conexia.qa.savia.models;

public class NegociacionPrestador {

	private String modalidad;
	private String regimen;
	private String poblacion;
	private String complejidad;
	private String numeroNegociacion;

	private static NegociacionPrestador negociacionPrestador;

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getComplejidad() {
		return complejidad;
	}

	public void setComplejidad(String complejidad) {
		this.complejidad = complejidad;
	}
	
	public String getNumeroNegociacion() {
		return numeroNegociacion;
	}

	public void setNumeroNegociacion(String numeroNegociacion) {
		this.numeroNegociacion = numeroNegociacion;
	}

	public static void guardarNegociacionPrestador(NegociacionPrestador pnegociacionPrestador) {
		if (negociacionPrestador != null) {
			negociacionPrestador = new NegociacionPrestador();
		}
		negociacionPrestador = pnegociacionPrestador;
	}

	public static NegociacionPrestador traerNegociacionPrestador() {
		return negociacionPrestador;
	}
	
	public static void limpioDatosNegociacionPrestador() {
			negociacionPrestador = new NegociacionPrestador();
	}
	
	

}
