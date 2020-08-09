package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.HistoriaClinicaPage.EVALUACION;
import static com.conexia.qa.savia.user_interfaces.HistoriaClinicaPage.FECHA_DESDE;
import static com.conexia.qa.savia.user_interfaces.HistoriaClinicaPage.FECHA_HASTA;
import static com.conexia.qa.savia.user_interfaces.HistoriaClinicaPage.HOY;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.Esperar;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class IngresarHistoriaClinica implements Task{

	private String evaluacion;
	
	
	public IngresarHistoriaClinica(String evaluacion) {
		this.evaluacion = evaluacion;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		actor.attemptsTo(Click.on(FECHA_DESDE));
		actor.attemptsTo(Click.on(HOY));
		actor.attemptsTo(Esperar.por(1000));
		actor.attemptsTo(Click.on(FECHA_HASTA));
		actor.attemptsTo(Esperar.por(1000));
		actor.attemptsTo(Click.on(HOY));
		takeScreenshot();
		actor.attemptsTo(Enter.theValue(evaluacion).into(EVALUACION));
		actor.attemptsTo(Esperar.por(12000));
		takeScreenshot();
	}

	public static IngresarHistoriaClinica con (String evaluacion) {
		
		return Tasks.instrumented(IngresarHistoriaClinica.class, evaluacion);
	}
}
