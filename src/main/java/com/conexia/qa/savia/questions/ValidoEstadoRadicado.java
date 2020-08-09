package com.conexia.qa.savia.questions;

import static com.conexia.qa.savia.user_interfaces.ListaTrabajoRadicadoPage.ESTADO_RADICADO;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;
/**
 * @author ChristianSchottlaender
 * **/
public class ValidoEstadoRadicado implements Question<Boolean>{

	private String estado;
	
	
	public ValidoEstadoRadicado(String estado) {
		this.estado = estado;
	}

	@Override
	@Step("{0} estado del redicado")
	public Boolean answeredBy(Actor actor) {
		takeScreenshot();
		return ESTADO_RADICADO.of(estado).resolveFor(actor).isVisible();
	}

	public static ValidoEstadoRadicado enListaDeTrabajo (String estado) {
		return new ValidoEstadoRadicado(estado);
	}
}
