package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.ListaTrabajoRadicadoPage.FILTRAR_POR_;

import org.openqa.selenium.Keys;

import com.conexia.qa.savia.interactions.Esperar;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.thucydides.core.annotations.Step;

public class BuscarRadicado implements Task{

	private String filtrarPor;
	private String valorBusqueda;
	
	
	public BuscarRadicado(String filtrarPor, String valorBusqueda) {
		this.filtrarPor = filtrarPor;
		this.valorBusqueda = valorBusqueda;
	}

	@Override
	@Step("{0} consulta radicado listas de trabajo #filtrarPor, #valorBusqueda")
	public <T extends Actor> void performAs(T actor) {
		
		actor.attemptsTo(Click.on(FILTRAR_POR_.of(filtrarPor)));
		actor.attemptsTo(Enter.theValue(valorBusqueda).into(FILTRAR_POR_.of(filtrarPor)));
		actor.attemptsTo(Hit.the(Keys.ENTER).into(FILTRAR_POR_.of(filtrarPor)),Esperar.por(2000));
		
	}
	
	public static BuscarRadicado porFiltros(String filtrarPor, String valorBusqueda) {
		return Tasks.instrumented(BuscarRadicado.class, filtrarPor, valorBusqueda);
	}

}
