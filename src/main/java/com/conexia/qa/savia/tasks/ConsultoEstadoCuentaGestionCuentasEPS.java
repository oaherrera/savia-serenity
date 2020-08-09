package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.FormularioGestionDeCuentasValidadasPage.BOTON_BUSCAR_GESTIONCTASEPS;
import static com.conexia.qa.savia.user_interfaces.FormularioGestionDeCuentasValidadasPage.BUSCAR;
import static com.conexia.qa.savia.user_interfaces.FormularioGestionDeCuentasValidadasPage.NUMERO_DE_CUENTA;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.Esperar;
import com.conexia.qa.savia.user_interfaces.FormularioGestionDeCuentasValidadasPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class ConsultoEstadoCuentaGestionCuentasEPS  implements Task {
	
	
	private String numeroDeCuenta;
	
	public ConsultoEstadoCuentaGestionCuentasEPS( String numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		actor.attemptsTo(Enter.theValue(numeroDeCuenta).into(NUMERO_DE_CUENTA));
		takeScreenshot();
		actor.attemptsTo(Click.on(BOTON_BUSCAR_GESTIONCTASEPS));
		takeScreenshot();
		actor.attemptsTo(Esperar.por(2000));
		
		
	}
	
	public static ConsultoEstadoCuentaGestionCuentasEPS conLaCuentaDeLaIps(String numeroDeCuenta ) {
		return Tasks.instrumented(ConsultoEstadoCuentaGestionCuentasEPS.class, numeroDeCuenta );
	}

}
