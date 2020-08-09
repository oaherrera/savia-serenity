package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.SolicitudPage.JUSTIFICACION_CLINICA;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.Esperar;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

public class IngresaJustificacionClinica implements Task {

	private String justificacion;
	
	
	public IngresaJustificacionClinica(String justificacion) {	
		this.justificacion = justificacion;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Esperar.por(300));
		takeScreenshot();
		actor.attemptsTo(Enter.theValue(justificacion).into(JUSTIFICACION_CLINICA));
		takeScreenshot();
		actor.attemptsTo(Esperar.por(300));
	}

	public static IngresaJustificacionClinica conElValor(String justificacion) {
		return Tasks.instrumented(IngresaJustificacionClinica.class, justificacion);
	}

}
