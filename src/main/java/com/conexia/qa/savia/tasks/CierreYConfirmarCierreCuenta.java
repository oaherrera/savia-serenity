package com.conexia.qa.savia.tasks;

import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.user_interfaces.RadicadoGestionRadicadoPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class CierreYConfirmarCierreCuenta implements Task{
	
	public CierreYConfirmarCierreCuenta() {
	}

	@Override
	@Step("{0} opción cerrar cuenta y confirmar cerrar")
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		actor.attemptsTo(Click.on(RadicadoGestionRadicadoPage.CERRAR_CUENTA));
		takeScreenshot();
		actor.attemptsTo(Click.on(RadicadoGestionRadicadoPage.CONFIRMAR_CIERRE_CUENTA));
		takeScreenshot();
	}

	public static CierreYConfirmarCierreCuenta enBandejaRadicado() {
		return Tasks.instrumented(CierreYConfirmarCierreCuenta.class);
	}

}
