package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.RadicadoFacturasRadicadasPage.MARCAR_COMO_REVISADO;
import static com.conexia.qa.savia.user_interfaces.RadicadoFacturasRadicadasPage.MARCAR_TODOS;
import static com.conexia.qa.savia.user_interfaces.CommonPage.CONFIRMAR_ACEPTAR;
import static com.conexia.qa.savia.user_interfaces.CommonPage.VOLVER;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.EsperarCargando;
import com.conexia.qa.savia.interactions.MueveScroll;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class FacturasRadicadasMarco implements Task{

	public Boolean comoRevisadas;
	
	public FacturasRadicadasMarco(Boolean comoRevisadas) {
		this.comoRevisadas = comoRevisadas;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(MueveScroll.vertical(300));
		actor.attemptsTo(Click.on(MARCAR_TODOS));
		takeScreenshot();
			if(comoRevisadas) {
			actor.attemptsTo(Click.on(MARCAR_COMO_REVISADO));
			actor.attemptsTo(Click.on(CONFIRMAR_ACEPTAR),EsperarCargando.pagina());
			takeScreenshot();
			actor.attemptsTo(Click.on(VOLVER));
			}
			takeScreenshot();
	}
	
	public static FacturasRadicadasMarco todasLasFacturas(Boolean comoRevisadas) {
		return Tasks.instrumented(FacturasRadicadasMarco.class, comoRevisadas);
	}



}
