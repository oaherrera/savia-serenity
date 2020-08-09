package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.FormularioGestionCuentasEpsPage.BUSCAR;
import static com.conexia.qa.savia.user_interfaces.FormularioGestionCuentasEpsPage.NUMERO_CUENTA;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class ConsultoEstadoCuentaComoEps implements Task {

	private String numeroDeCuenta;

	public ConsultoEstadoCuentaComoEps(String numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		actor.attemptsTo(Enter.theValue(numeroDeCuenta).into(NUMERO_CUENTA));
		actor.attemptsTo(Click.on(BUSCAR));
		takeScreenshot();
	}

	public static ConsultoEstadoCuentaComoEps conLaCuenta(String numeroDeCuenta) {
		return Tasks.instrumented(ConsultoEstadoCuentaComoEps.class, numeroDeCuenta);

	}

}
