package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.SolicitudPage.VALIDAR;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.EsperarCargando;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class ValidoSolicitud implements Task {

	public ValidoSolicitud() {
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		actor.attemptsTo(Click.on(VALIDAR));
		actor.attemptsTo(EsperarCargando.pagina());
		takeScreenshot();
	}

	public static ValidoSolicitud enviandola() {
		return Tasks.instrumented(ValidoSolicitud.class);
	}

}
