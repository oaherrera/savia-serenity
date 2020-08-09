package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.InsumoPage.AGREGAR_INSUMO;
import static com.conexia.qa.savia.user_interfaces.InsumoPage.DIAGNOSTICO;
import static com.conexia.qa.savia.user_interfaces.InsumoPage.DIAGNOSTICO_SELECT;
import static com.conexia.qa.savia.user_interfaces.InsumoPage.DURACION_TRATAMIENTO;
import static com.conexia.qa.savia.user_interfaces.InsumoPage.GUARDAR;
import static com.conexia.qa.savia.user_interfaces.InsumoPage.ID_DESCRIPCION_UNSUMO;
import static com.conexia.qa.savia.user_interfaces.InsumoPage.ID_DESCRIPCION_UNSUMO_SELECT;
import static com.conexia.qa.savia.user_interfaces.InsumoPage.TAB_INSUMOS;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.Esperar;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class AgregaInsumo implements Task {

	private String idDescripcionInsumo;
	private String diagnostico;
	private String duracionTratamientoEnDias;

	public AgregaInsumo(String idDescripcionInsumo, String diagnostico, String duracionTratamientoEnDias) {
		this.idDescripcionInsumo = idDescripcionInsumo;
		this.diagnostico = diagnostico;
		this.duracionTratamientoEnDias = duracionTratamientoEnDias;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		actor.attemptsTo(Click.on(TAB_INSUMOS));
		actor.attemptsTo(Enter.theValue(idDescripcionInsumo).into(ID_DESCRIPCION_UNSUMO));
		actor.attemptsTo(Click.on(ID_DESCRIPCION_UNSUMO_SELECT.of(idDescripcionInsumo)));
		actor.attemptsTo(Click.on(DIAGNOSTICO));
		actor.attemptsTo(Click.on(DIAGNOSTICO_SELECT.of(diagnostico)));
		takeScreenshot();
		actor.attemptsTo(Click.on(AGREGAR_INSUMO));
		actor.attemptsTo(Enter.theValue(duracionTratamientoEnDias).into(DURACION_TRATAMIENTO));
		takeScreenshot();
		actor.attemptsTo(Click.on(GUARDAR));
		actor.attemptsTo(Esperar.por(300));
		takeScreenshot();

	}

	public static AgregaInsumo tipoPBS(String idDescripcionInsumo, String diagnostico,
			String duracionTratamientoEnDias) {

		return Tasks.instrumented(AgregaInsumo.class, idDescripcionInsumo, diagnostico, duracionTratamientoEnDias);
	}

}
