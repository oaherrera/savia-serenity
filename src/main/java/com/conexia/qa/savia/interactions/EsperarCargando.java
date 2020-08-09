package com.conexia.qa.savia.interactions;

import static com.conexia.qa.savia.drivers.OwnWebDriver.getDriver;
import static com.conexia.qa.savia.user_interfaces.CommonPage.CARGANDO;
import static java.util.concurrent.TimeUnit.SECONDS;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class EsperarCargando implements Interaction {

	@Override
	public <T extends Actor> void performAs(T actor) {
			actor.attemptsTo(Esperar.por(1000));
			getDriver().manage().timeouts().implicitlyWait(2, SECONDS);
			while (CARGANDO.resolveFor(actor).isVisible()) {
				actor.attemptsTo(Esperar.por(1000));
			}
			getDriver().manage().timeouts().implicitlyWait(10, SECONDS);
	}

	public static EsperarCargando pagina() {
		return Tasks.instrumented(EsperarCargando.class);
	}

}
