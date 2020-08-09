package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.models.NegociacionPrestador.traerNegociacionPrestador;
import static com.conexia.qa.savia.user_interfaces.CommonPage.ACEPTAR;
import static com.conexia.qa.savia.user_interfaces.NegociacionPage.COMPLEJIDAD;
import static com.conexia.qa.savia.user_interfaces.NegociacionPage.COMPLEJIDAD_SELECCION;
import static com.conexia.qa.savia.user_interfaces.NegociacionPage.CREAR_NEGOCIACION;
import static com.conexia.qa.savia.user_interfaces.NegociacionPage.MODALIDAD_NEGOCIACION;
import static com.conexia.qa.savia.user_interfaces.NegociacionPage.MODALIDAD_NEGOCIACION_SELECCION;
import static com.conexia.qa.savia.user_interfaces.NegociacionPage.MODALIDAD_REGIMEN_SELECCION;
import static com.conexia.qa.savia.user_interfaces.NegociacionPage.POBLACION;
import static com.conexia.qa.savia.user_interfaces.NegociacionPage.REGIMEN_NEGOCIACION;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.EsperarCargando;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class CreaLaBaseDeNegociacion implements Task {

	private String modalidad;
	private String regimen;
	private String poblacion;
	private String complejidad;
	
	public CreaLaBaseDeNegociacion(String modalidad, String regimen, String poblacion, String complejidad) {
		this.modalidad = modalidad;
		this.regimen = regimen;
		this.poblacion = poblacion;
		this.complejidad = complejidad;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		actor.attemptsTo(Click.on(CREAR_NEGOCIACION),EsperarCargando.pagina());
		actor.attemptsTo(Click.on(MODALIDAD_NEGOCIACION),EsperarCargando.pagina());
		actor.attemptsTo(Click.on(MODALIDAD_NEGOCIACION_SELECCION.of(modalidad)),EsperarCargando.pagina());
		actor.attemptsTo(Click.on(REGIMEN_NEGOCIACION),EsperarCargando.pagina());
		actor.attemptsTo(Click.on(MODALIDAD_REGIMEN_SELECCION.of(regimen)),EsperarCargando.pagina());
		actor.attemptsTo(Enter.theValue(poblacion).into(POBLACION),EsperarCargando.pagina());
		actor.attemptsTo(Click.on(COMPLEJIDAD),EsperarCargando.pagina());
		actor.attemptsTo(Click.on(COMPLEJIDAD_SELECCION.of(complejidad)),EsperarCargando.pagina());
		takeScreenshot();
		actor.attemptsTo(Click.on(ACEPTAR),EsperarCargando.pagina());
		takeScreenshot();
	}
	
	public static CreaLaBaseDeNegociacion conLosDatos() {
		return Tasks.instrumented(CreaLaBaseDeNegociacion.class,
				traerNegociacionPrestador().getModalidad(),
				traerNegociacionPrestador().getRegimen(),
				traerNegociacionPrestador().getPoblacion(),
				traerNegociacionPrestador().getComplejidad()
				);
	}


}
