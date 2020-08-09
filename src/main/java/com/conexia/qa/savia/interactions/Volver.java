package com.conexia.qa.savia.interactions;

import static com.conexia.qa.savia.user_interfaces.CommonPage.VOLVER;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class Volver implements Interaction{

	
	public Volver() {
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(EsperarCargando.pagina(), Click.on(VOLVER),EsperarCargando.pagina() );
	}
	
	public static Volver alFormularioAnterior() {
		return Tasks.instrumented(Volver.class);
	}

}
