
package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.TipoSolicitudPage.PROGRAMA;
import static com.conexia.qa.savia.user_interfaces.TipoSolicitudPage.PROGRAMA_SELECCION;
import static com.conexia.qa.savia.user_interfaces.TipoSolicitudPage.SERVICIO_DE_ATENCION;
import static com.conexia.qa.savia.user_interfaces.TipoSolicitudPage.SERVICIO_DE_ATENCION_SELECCION;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class DiligenciaTipoDeSolicitud implements Task {

	private String servicioAtencion;
	private String programa;

	public DiligenciaTipoDeSolicitud(String servicioAtencion, String programa) {
		this.servicioAtencion = servicioAtencion;
		this.programa = programa;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		actor.attemptsTo(Click.on(SERVICIO_DE_ATENCION));
		actor.attemptsTo(Click.on(SERVICIO_DE_ATENCION_SELECCION.of(servicioAtencion)));
		actor.attemptsTo(Click.on(PROGRAMA));
		actor.attemptsTo(Click.on(PROGRAMA_SELECCION.of(programa)));
		takeScreenshot();
	}

	public static DiligenciaTipoDeSolicitud enElFormulario(String servicioAtencion, String programa) {
		return Tasks.instrumented(DiligenciaTipoDeSolicitud.class, servicioAtencion, programa);
	}

}
