package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.RadicadoAsignarPage.CARGO;
import static com.conexia.qa.savia.user_interfaces.RadicadoAsignarPage.CARGO_SELECCION;
import static com.conexia.qa.savia.user_interfaces.RadicadoAsignarPage.MARCAR;
import static com.conexia.qa.savia.user_interfaces.RadicadoAsignarPage.NOMBRE;
import static com.conexia.qa.savia.user_interfaces.RadicadoAsignarPage.NOMBRE_SELECCION;
import static com.conexia.qa.savia.user_interfaces.RadicadoAsignarPage.REGIONAL;
import static com.conexia.qa.savia.user_interfaces.RadicadoAsignarPage.REGIONAL_SELECCION;
import static com.conexia.qa.savia.user_interfaces.CommonPage.AGREGAR;
import static com.conexia.qa.savia.user_interfaces.CommonPage.ASIGNAR;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.Esperar;
import com.conexia.qa.savia.interactions.EsperarCargando;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class AsignoEnBandejaRadicados implements Task {

	private String regional;
	private String cargo;
	private String nombre;

	public AsignoEnBandejaRadicados(String regional, String cargo, String nombre) {
		this.regional = regional.trim();
		this.cargo = cargo.trim();
		this.nombre = nombre.trim();
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		takeScreenshot();
		actor.attemptsTo(Click.on(REGIONAL));
		actor.attemptsTo(Click.on(REGIONAL_SELECCION.of(regional)));
		actor.attemptsTo(Click.on(CARGO));
		actor.attemptsTo(Click.on(CARGO_SELECCION.of(cargo)),EsperarCargando.pagina(),Esperar.por(1000));
		actor.attemptsTo(Enter.theValue(nombre).into(NOMBRE));
		actor.attemptsTo(Click.on(NOMBRE_SELECCION.of(nombre)));
		takeScreenshot();
		actor.attemptsTo(Click.on(AGREGAR));
		takeScreenshot();
		actor.attemptsTo(Click.on(MARCAR.of(cargo)));
		actor.attemptsTo(Click.on(ASIGNAR));
		takeScreenshot();
		
	}

	public static AsignoEnBandejaRadicados alUsuarioConLosDatos(String regional, String cargo, String nombre) {
		return Tasks.instrumented(AsignoEnBandejaRadicados.class, regional, cargo, nombre);
	}

}
