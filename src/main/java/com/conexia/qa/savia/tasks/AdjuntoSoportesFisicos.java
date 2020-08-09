package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.SoportesFisicosPage.ADJUNTAR_ARCHIVO;
import static com.conexia.qa.savia.user_interfaces.SoportesFisicosPage.AGREGAR;
import static com.conexia.qa.savia.user_interfaces.SoportesFisicosPage.OBSERVACIONES;
import static com.conexia.qa.savia.user_interfaces.SoportesFisicosPage.TIPO_DE_DOCUMENTO;
import static com.conexia.qa.savia.user_interfaces.SoportesFisicosPage.TIPO_DE_DOCUMENTO_SELECCION;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.AdjuntoArchivo;
import com.conexia.qa.savia.interactions.Esperar;
import com.conexia.qa.savia.interactions.EsperarCargando;
import com.conexia.qa.savia.interactions.MueveScroll;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class AdjuntoSoportesFisicos implements Task {

	private String ruta;
	private String deTipo;

	public AdjuntoSoportesFisicos(String ruta, String deTipo) {
		this.ruta = ruta;
		this.deTipo = deTipo;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(MueveScroll.vertical(400),Esperar.por(300));
		takeScreenshot();
		actor.attemptsTo(AdjuntoArchivo.con(ruta, ADJUNTAR_ARCHIVO),Esperar.por(300),EsperarCargando.pagina());
		actor.attemptsTo(Click.on(TIPO_DE_DOCUMENTO),Esperar.por(300));
		actor.attemptsTo(Click.on(TIPO_DE_DOCUMENTO_SELECCION.of(deTipo)),Esperar.por(300));
		takeScreenshot();
		actor.attemptsTo(Click.on(AGREGAR),Esperar.por(3000));
		takeScreenshot();
		actor.attemptsTo(Enter.theValue("Observaciones Prueba").into(OBSERVACIONES),Esperar.por(300));
		takeScreenshot();
	}

	public static AdjuntoSoportesFisicos enLaSolicitud(String ruta, String deTipo) {

		return Tasks.instrumented(AdjuntoSoportesFisicos.class, ruta, deTipo);
	}

}
