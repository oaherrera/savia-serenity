package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.ListaTrabajoRadicadoPage.ASIGNAR;
import static com.conexia.qa.savia.user_interfaces.ListaTrabajoRadicadoPage.CONFIRMAR_CERRAR_CUENTA;
import static com.conexia.qa.savia.user_interfaces.ListaTrabajoRadicadoPage.FINALIZAR_AUDITORIA;
import static com.conexia.qa.savia.user_interfaces.ListaTrabajoRadicadoPage.VER_DETALLE;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class ListasDeTrabajo implements Task {

	private String accionEnListraTrabajo;

	public ListasDeTrabajo(String accionEnListraTrabajo) {
		this.accionEnListraTrabajo = accionEnListraTrabajo;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		switch (accionEnListraTrabajo) {
		case "Ver Detalle":
			actor.attemptsTo(Click.on(VER_DETALLE));
			break;
		case "Asignar":
			actor.attemptsTo(Click.on(ASIGNAR));
			break;
		case "Finalizar Auditoria":
			actor.attemptsTo(Click.on(FINALIZAR_AUDITORIA));
			takeScreenshot();
			actor.attemptsTo(Click.on(CONFIRMAR_CERRAR_CUENTA));
			break;
		}
		takeScreenshot();
	}

	public static ListasDeTrabajo realizoAccion(String accionEnListraTrabajo) {
		return Tasks.instrumented(ListasDeTrabajo.class, accionEnListraTrabajo);
	}

}
