package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.PROCEDIMIENTO_CODIGO;
import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.PROCEDIMIENTO_CODIGO_SELECCION;
import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.SERVICIO;
import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.SERVICIO_SELECCION;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.Esperar;

import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.DIAGNOSTICO;
import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.DIAGNOSTICO_SELECCION;
import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.AGREGAR;
import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.ES_POSFECHADO;
import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.DURACION_DEL_TRATAMIENTO;
import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.INDICACIONES;
import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.GUARDAR;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class AgregaProcedimiento implements Task {

	private String codigoProcedimiento;
	private String duracionTratamientoDias;
	private String indicaciones;

	public AgregaProcedimiento(String codigoProcedimiento, String duracionTratamientoDias, String indicaciones) {
		this.codigoProcedimiento = codigoProcedimiento;
		this.duracionTratamientoDias = duracionTratamientoDias;
		this.indicaciones = indicaciones;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Esperar.por(2000));
		takeScreenshot();
		actor.attemptsTo(Enter.theValue(codigoProcedimiento).into(PROCEDIMIENTO_CODIGO));
		actor.attemptsTo(Click.on(PROCEDIMIENTO_CODIGO_SELECCION));
		takeScreenshot();
		actor.attemptsTo(Click.on(SERVICIO));
		actor.attemptsTo(Click.on(SERVICIO_SELECCION));
		actor.attemptsTo(Click.on(DIAGNOSTICO));
		actor.attemptsTo(Click.on(DIAGNOSTICO_SELECCION));
		takeScreenshot();
		actor.attemptsTo(Click.on(AGREGAR), Esperar.por(3000));
		actor.attemptsTo(Click.on(ES_POSFECHADO));
		actor.attemptsTo(Enter.theValue(duracionTratamientoDias).into(DURACION_DEL_TRATAMIENTO));
		actor.attemptsTo(Enter.theValue(indicaciones).into(INDICACIONES));
		takeScreenshot();
		actor.attemptsTo(Click.on(GUARDAR));
		takeScreenshot();
	}

	public static AgregaProcedimiento tipoPBS(String codigoProcedimiento, String duracionTratamientoDias,
			String indicaciones) {
		return Tasks.instrumented(AgregaProcedimiento.class, codigoProcedimiento, duracionTratamientoDias,
				indicaciones);
	}

}
