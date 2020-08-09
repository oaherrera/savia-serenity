package com.conexia.qa.savia.models;

import java.util.ArrayList;
import java.util.List;

public class FiltrosBusqueda {

	private String  filtrarPor; 
	private String valorBusqueda ;
	
	private static List<FiltrosBusqueda> InformacionFiltrosBusquedaData= new ArrayList<FiltrosBusqueda>();

	public String getFiltrarPor() {
		return filtrarPor;
	}

	public void setFiltrarPor(String filtrarPor) {
		this.filtrarPor = filtrarPor;
	}

	public String getValorBusqueda() {
		return valorBusqueda;
	}

	public void setValorBusqueda(String valorBusqueda) {
		this.valorBusqueda = valorBusqueda;
	}

	public static FiltrosBusqueda traerInformacion(int indice) {
		return InformacionFiltrosBusquedaData.get(indice);
	}

	public static void guardarInformacion(FiltrosBusqueda FiltrosBusqueda) {
		InformacionFiltrosBusquedaData.add(FiltrosBusqueda);
	}
	
	public static void guardarInformacion(List<FiltrosBusqueda> filtrosBusqueda) {
		int indice = 0;
		while (indice <filtrosBusqueda.size()) {
			guardarInformacion(filtrosBusqueda.get(indice));
			indice = indice + 1;
		}
	}
	
	public static void limpiarInformacion() {
		InformacionFiltrosBusquedaData = new ArrayList<FiltrosBusqueda>();
	}
	
}
