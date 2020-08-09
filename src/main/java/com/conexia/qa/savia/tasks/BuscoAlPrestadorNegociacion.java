package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.BandejaPrestadorNegociacionPage.FILTRO_NOMBRE;
import static com.conexia.qa.savia.user_interfaces.BandejaPrestadorNegociacionPage.VER_NEGOCIACIONES;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import org.openqa.selenium.Keys;

import com.conexia.qa.savia.interactions.Esperar;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;

public class BuscoAlPrestadorNegociacion implements Task{

	private String nombreprestador;
	private String realizarAccionAlBuscar;
	
	public BuscoAlPrestadorNegociacion(String nombreprestador, String realizarAccionAlBuscar) {
		this.nombreprestador = nombreprestador;
		this.realizarAccionAlBuscar = realizarAccionAlBuscar;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		if(nombreprestador!=null) {
			actor.attemptsTo(Enter.theValue(nombreprestador).into(FILTRO_NOMBRE));
			actor.attemptsTo(Hit.the(Keys.ENTER).into(FILTRO_NOMBRE));
			actor.attemptsTo(Esperar.por(2000));
			takeScreenshot();
		}
		
		if(realizarAccionAlBuscar!=null) {
			switch (realizarAccionAlBuscar) {
			case "Ver Negociaciones":
				actor.attemptsTo(Click.on(VER_NEGOCIACIONES));
				takeScreenshot();
			}
		}
	}
	
	public static BuscoAlPrestadorNegociacion porNombre(String nombreprestador) {
		return Tasks.instrumented(BuscoAlPrestadorNegociacion.class, nombreprestador,null);
	}

	public static BuscoAlPrestadorNegociacion para(String realizarAccionAlBuscar) {
		return Tasks.instrumented(BuscoAlPrestadorNegociacion.class, null,realizarAccionAlBuscar);
	}


	

}
