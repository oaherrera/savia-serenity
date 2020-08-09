package com.conexia.qa.savia.tasks;

import com.conexia.qa.savia.interactions.Esperar;
import com.conexia.qa.savia.interactions.HacerClic;
import com.conexia.qa.savia.interactions.Sleep;
import com.conexia.qa.savia.user_interfaces.CommonPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class EnviarAHomologar implements Task {
	
	public EnviarAHomologar() {
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Esperar.por(3000));
		actor.attemptsTo(HacerClic.En(CommonPage.ENVIAR_HOMOLOGACION));
		actor.attemptsTo(Esperar.por(1000));
		actor.attemptsTo(Click.on(CommonPage.CONFIRMAR_SI));
		actor.attemptsTo(Esperar.por(5000));
	}

	public static EnviarAHomologar cuenta() {

		return Tasks.instrumented(EnviarAHomologar.class);
	}

}
