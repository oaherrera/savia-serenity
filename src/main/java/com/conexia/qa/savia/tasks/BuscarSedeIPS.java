package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.SedeIPSPage.RAZON_SOCIAL;
import static com.conexia.qa.savia.user_interfaces.SedeIPSPage.TIPO_DE_DOCUMENTO;
import static com.conexia.qa.savia.user_interfaces.SedeIPSPage.TIPO_DE_DOCUMENTO_SELECCION;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.DobleClic;
import com.conexia.qa.savia.interactions.EsperarCargando;

import static com.conexia.qa.savia.user_interfaces.SedeIPSPage.NUMERO_DE_DOCUMENTO;
import static com.conexia.qa.savia.user_interfaces.SedeIPSPage.DEPARTAMENTO;
import static com.conexia.qa.savia.user_interfaces.SedeIPSPage.DEPARTAMENTO_SELECCION;
import static com.conexia.qa.savia.user_interfaces.SedeIPSPage.MUNICIPIO;
import static com.conexia.qa.savia.user_interfaces.SedeIPSPage.MUNICIPIO_SELECCION;
import static com.conexia.qa.savia.user_interfaces.SedeIPSPage.BUSCAR;
import static com.conexia.qa.savia.user_interfaces.SedeIPSPage.TABLA_DE_SEDES;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class BuscarSedeIPS implements Task {

	private String tipoDocumento;
	private String nroDocumento;
	private String nombreRazonSocial;
	private String departamento;
	private String municipio;
	private String tipoBusqueda;

	public BuscarSedeIPS(String tipoDocumento, String nroDocumento, String nombreRazonSocial, String departamento,
			String municipio, String tipoBusqueda) {
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nombreRazonSocial = nombreRazonSocial;
		this.departamento = departamento;
		this.municipio = municipio;
		this.tipoBusqueda = tipoBusqueda;

	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		takeScreenshot();
		switch (tipoBusqueda) {
		case "porTipoDocumento":
			actor.attemptsTo(Click.on(TIPO_DE_DOCUMENTO));
			actor.attemptsTo(Click.on(TIPO_DE_DOCUMENTO_SELECCION.of(tipoDocumento)));
			actor.attemptsTo(Enter.theValue(nroDocumento).into(NUMERO_DE_DOCUMENTO));
			break;
		case "porRazonSocial":
			actor.attemptsTo(Enter.theValue(nombreRazonSocial).into(RAZON_SOCIAL));
			break;
		case "porDapartamentoMunicipio":
			actor.attemptsTo(Click.on(DEPARTAMENTO));
			actor.attemptsTo(Click.on(DEPARTAMENTO_SELECCION.of(departamento)));
			actor.attemptsTo(Click.on(MUNICIPIO));
			actor.attemptsTo(Click.on(MUNICIPIO_SELECCION.of(municipio)));
			break;
		}
		takeScreenshot();
		actor.attemptsTo(Click.on(BUSCAR));
		actor.attemptsTo(EsperarCargando.pagina());
		takeScreenshot();
		actor.attemptsTo(DobleClic.En(TABLA_DE_SEDES));
		actor.attemptsTo(EsperarCargando.pagina());
		takeScreenshot();

	}

	public static BuscarSedeIPS porTipoDocumento(String tipoDocumento, String nroDocumento) {
		return Tasks.instrumented(BuscarSedeIPS.class, tipoDocumento, nroDocumento, null, null, null,
				"porTipoDocumento");
	}

	public static BuscarSedeIPS porRazonSocial(String nombreRazonSocial) {
		return Tasks.instrumented(BuscarSedeIPS.class, null, null, nombreRazonSocial, null, null, "porRazonSocial");
	}

	public static BuscarSedeIPS porDapartamentoMunicipio(String departamento, String municipio) {
		return Tasks.instrumented(BuscarSedeIPS.class, null, null, null, departamento, municipio,
				"porDapartamentoMunicipio");
	}

}
