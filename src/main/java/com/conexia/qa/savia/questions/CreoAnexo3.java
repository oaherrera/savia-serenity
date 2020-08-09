package com.conexia.qa.savia.questions;

import static com.conexia.qa.savia.user_interfaces.ImprimirTicket.MENSAJE_EJECUTO_CORRECTAMENTE;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CreoAnexo3 implements Question<Boolean>{

	@Override
	public Boolean answeredBy(Actor actor) {
		takeScreenshot();
		return MENSAJE_EJECUTO_CORRECTAMENTE.resolveFor(actor).isVisible();
	}
	
	public static CreoAnexo3 Correctamente() {
		return new CreoAnexo3();
		
	}

}
