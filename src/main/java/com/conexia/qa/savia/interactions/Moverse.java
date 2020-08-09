package com.conexia.qa.savia.interactions;

import org.openqa.selenium.interactions.Actions;

import com.conexia.qa.savia.drivers.OwnWebDriver;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class Moverse implements Interaction {

	private Target objeto;

	public Moverse(Target objeto) {
		this.objeto = objeto;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		Actions actions = new Actions(OwnWebDriver.getDriver());
		actions.moveToElement(objeto.resolveFor(actor));
		actions.perform();
		while (!objeto.resolveFor(actor).isEnabled()||!objeto.resolveFor(actor).isDisplayed()) {
			Esperar.por(1000);
		}
	}

	public static Moverse hasta(Target objeto) {
		return Tasks.instrumented(Moverse.class, objeto);

	}

}
