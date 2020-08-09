package com.conexia.qa.savia.models;

public class MensajeTemporal {

	private static String MENSAJE;

	public static String traerMensaje() {
		return MENSAJE;
	}

	public static void guardarMensaje(String mENSAJE) {
		MENSAJE = mENSAJE;
	}
	
	

}
