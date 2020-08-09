package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.ConfirmarDerechosPage.ACEPTAR;
import static com.conexia.qa.savia.user_interfaces.ConfirmarDerechosPage.BUSCAR;
import static com.conexia.qa.savia.user_interfaces.ConfirmarDerechosPage.NUMERO_DOCUMENTO;
import static com.conexia.qa.savia.user_interfaces.ConfirmarDerechosPage.TIPO_DOCUMENTO;
import static com.conexia.qa.savia.user_interfaces.ConfirmarDerechosPage.TIPO_DOCUMENTO_OPCION;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.EsperarCargando;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

public class BuscarAfiliado implements Task {

	private String TipoDocumento;
	private String NroDocumento;

	public BuscarAfiliado(String tipoDocumento, String nroDocumento) {
		this.TipoDocumento = tipoDocumento;
		this.NroDocumento = nroDocumento;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		actor.attemptsTo(Click.on(TIPO_DOCUMENTO));
		actor.attemptsTo(Click.on(TIPO_DOCUMENTO_OPCION.of(TipoDocumento)));
		actor.attemptsTo(EsperarCargando.pagina());
		actor.attemptsTo(Enter.theValue(NroDocumento).into(NUMERO_DOCUMENTO));
		takeScreenshot();
		actor.attemptsTo(Click.on(BUSCAR));
		actor.attemptsTo(EsperarCargando.pagina());
		actor.attemptsTo(Scroll.to(ACEPTAR));
		takeScreenshot();
		actor.attemptsTo(Click.on(ACEPTAR));
		takeScreenshot();

	}

	public static BuscarAfiliado porTipoidentificacion(String tipoDocumento, String nroDocumento) {
		return Tasks.instrumented(BuscarAfiliado.class, tipoDocumento, nroDocumento);
	}

}
