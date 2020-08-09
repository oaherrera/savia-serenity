package com.conexia.qa.sql.modelos;

import java.util.ArrayList;
import java.util.List;

public class profesional extends tipoDocumento {

	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String numeroDocumento;
	private String especialidad;
	private String cargo;
	private static List<profesional> profesionales ;
	private static profesional Profesional;

	public static profesional traerProfesional() {
		if (Profesional == null) {
			Profesional = new profesional();
			profesionales = new ArrayList<profesional>();
		}
		return Profesional;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public List<profesional> Profesionales() {
		return profesionales;
	}

	public profesional traerProfesional(int indice) {
		return profesionales.get(indice);
	}

	public void guardarProfesionale(profesional profesional) {
		profesionales.add(Profesional);
	}

	public void borrarProfesionales() {
		profesionales = new ArrayList<profesional>();
	}
}
