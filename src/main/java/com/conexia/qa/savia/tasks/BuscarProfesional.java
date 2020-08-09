package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.ProfesionalPage.TIPO_DE_DOCUMENTO; 
import static com.conexia.qa.savia.user_interfaces.ProfesionalPage.TIPO_DE_DOCUMENTO_SELECCION;
import static com.conexia.qa.savia.user_interfaces.ProfesionalTablaResultadosPage.SELECCIONAR_PROFESIONAL;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.DobleClic;
import com.conexia.qa.savia.interactions.Esperar;
import com.conexia.qa.savia.interactions.EsperarCargando;
import com.conexia.qa.sql.modelos.profesional;
import com.conexia.qa.sql.tasks.consultoProfesional;

import static com.conexia.qa.savia.user_interfaces.ProfesionalPage.PRIMER_NOMBRE;
import static com.conexia.qa.savia.user_interfaces.ProfesionalPage.SEGUNDO_NOMBRE;
import static com.conexia.qa.savia.user_interfaces.ProfesionalPage.PRIMER_APELLIDO;
import static com.conexia.qa.savia.user_interfaces.ProfesionalPage.SEGUNDO_APELLIDO;
import static com.conexia.qa.savia.user_interfaces.ProfesionalPage.NUMERO_DE_DOCUMENTO;
import static com.conexia.qa.savia.user_interfaces.ProfesionalPage.BUSCAR;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class BuscarProfesional implements Task {

	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String tipoDocumento;
	private String numeroDocumento;
	private String tipoBusqueda;

	public BuscarProfesional(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			String tipoDocumento, String numeroDocumento, String tipoBusqueda) {
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.tipoBusqueda = tipoBusqueda;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		switch (tipoBusqueda) {
		case "numeroDocumento":
			actor.attemptsTo(EsperarCargando.pagina());
			actor.attemptsTo(Click.on(TIPO_DE_DOCUMENTO));
			actor.attemptsTo(EsperarCargando.pagina());
			actor.attemptsTo(Click.on(TIPO_DE_DOCUMENTO_SELECCION.of(tipoDocumento)));
			actor.attemptsTo(Esperar.por(1200));
			actor.attemptsTo(Click.on(NUMERO_DE_DOCUMENTO));
			actor.attemptsTo(Enter.theValue(numeroDocumento).into(NUMERO_DE_DOCUMENTO));
			actor.attemptsTo(consultoProfesional.porTipoDocumento(tipoDocumento, numeroDocumento));
			break;
		case "Nombres":
			actor.attemptsTo(Enter.theValue(primerNombre).into(PRIMER_NOMBRE));
			actor.attemptsTo(Enter.theValue(segundoNombre).into(SEGUNDO_NOMBRE));
			actor.attemptsTo(Enter.theValue(primerApellido).into(PRIMER_APELLIDO));
			actor.attemptsTo(Enter.theValue(segundoApellido).into(SEGUNDO_APELLIDO));
			//Falta agregar consulta a la base por nombres 
			break;
		default:
			break;
		}
		takeScreenshot();
		actor.attemptsTo(Click.on(BUSCAR),EsperarCargando.pagina());
		takeScreenshot();
		if (profesional.traerProfesional().Profesionales().size() > 1) {
			actor.attemptsTo(DobleClic.En(SELECCIONAR_PROFESIONAL.of("1")),EsperarCargando.pagina());
		}
		takeScreenshot();
	}

	public static BuscarProfesional porTipoDocumento(String tipoDocumento, String numeroDocumento) {
		return Tasks.instrumented(BuscarProfesional.class, null, null, null, null, tipoDocumento, numeroDocumento,
				"numeroDocumento");
	}

	public static BuscarProfesional porNombres(String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido) {
		return Tasks.instrumented(BuscarProfesional.class, primerNombre, segundoNombre, primerApellido, segundoApellido,
				null, null, "Nombres");
	}

}
