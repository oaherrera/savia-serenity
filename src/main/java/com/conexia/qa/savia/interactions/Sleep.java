package com.conexia.qa.savia.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class Sleep implements Interaction {

	private long miliseconds;

	public Sleep(long miliseconds) {
		this.miliseconds = miliseconds;
	}

	@Override
	@Step("{0} Wait Element")
	public <T extends Actor> void performAs(T actor) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static Sleep by(long miliseconds) {
		return Tasks.instrumented(Sleep.class, miliseconds);
	}

}