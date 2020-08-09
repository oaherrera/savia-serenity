package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.GestionCuentasEpsPage.ACCION;
import static com.conexia.qa.savia.user_interfaces.GestionCuentasPage.CONFIRMAR_SI;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.EsperarCargando;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class GestionoLaCuentaComoEps implements Task {

	private String accion;

	public GestionoLaCuentaComoEps(String accion) {
		this.accion = accion;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		takeScreenshot();
		switch (accion) {
		case "Devolución EPS":
			actor.attemptsTo(EsperarCargando.pagina(), Click.on(ACCION.of(accion)), EsperarCargando.pagina());
			takeScreenshot();
			break;
		case "Registrar Cuenta EPS":
			actor.attemptsTo(EsperarCargando.pagina(), Click.on(ACCION.of(accion)), EsperarCargando.pagina());
			takeScreenshot();
			break;
		
		}

		takeScreenshot();
	}

	public static GestionoLaCuentaComoEps realizandoLaAccion(String accion) {
		return Tasks.instrumented(GestionoLaCuentaComoEps.class, accion);

	}

}
