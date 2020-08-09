package com.conexia.qa.savia.questions;

import static com.conexia.qa.savia.user_interfaces.RadicadoAsignarPage.ASIGNACION_ACTUAL_NOMBRE;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class verEnAsignacionActual implements Question<Boolean>{

	private String usuario;
	
	public verEnAsignacionActual(String usuario) {
		this.usuario = usuario.trim();
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		return ASIGNACION_ACTUAL_NOMBRE.of(usuario).resolveFor(actor).isVisible();
	}

	public static verEnAsignacionActual alUsuario(String usuario) {
		return new verEnAsignacionActual(usuario);
	}
	


}
