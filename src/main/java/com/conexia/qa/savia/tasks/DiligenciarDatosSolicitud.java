package com.conexia.qa.savia.tasks;


import static com.conexia.qa.savia.user_interfaces.SolicitudPage.NUMERO_SOLICITUD;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

public class DiligenciarDatosSolicitud implements Task{

	private String nroSolicitud;
	
	public DiligenciarDatosSolicitud(String nroSolicitud) {
		this.nroSolicitud = nroSolicitud;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		actor.attemptsTo(Scroll.to(NUMERO_SOLICITUD));
		actor.attemptsTo(Enter.theValue(nroSolicitud).into(NUMERO_SOLICITUD));
		takeScreenshot();
	}
	
	public static DiligenciarDatosSolicitud enElFomularioSolicitud(String nroSolicitud) {
		return Tasks.instrumented(DiligenciarDatosSolicitud.class, nroSolicitud);
	}
	
	

}
