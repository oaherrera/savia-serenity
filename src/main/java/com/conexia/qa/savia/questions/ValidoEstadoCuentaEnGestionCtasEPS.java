package com.conexia.qa.savia.questions;

import static com.conexia.qa.savia.user_interfaces.ResultadoGestionDeCuentasValidadasPage.ESTADO_GESTION_CUENTAS_EPS;
import static com.conexia.qa.savia.user_interfaces.ResultadoGestionDeCuentasValidadasPage.NUMERO_CUENTA;
import static net.serenitybdd.core.Serenity.takeScreenshot;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidoEstadoCuentaEnGestionCtasEPS implements Question<Boolean> {

	private String estado;
	private String nroCuenta;

	public ValidoEstadoCuentaEnGestionCtasEPS(String estado, String nroCuenta) {
		this.estado = estado;
		this.nroCuenta = nroCuenta;
	}

	@Override
	public Boolean answeredBy(Actor actor) {

		takeScreenshot();
		if (!NUMERO_CUENTA.of(nroCuenta).resolveFor(actor).isVisible()) {
			takeScreenshot();
			System.out.println("Numero cuenta");
			return false;
		} else if (!ESTADO_GESTION_CUENTAS_EPS.of(estado).resolveFor(actor).isVisible()) {
			takeScreenshot();
			System.out.println("Estado");
			return false;
		}
		takeScreenshot();
		return true;
	}

	public static ValidoEstadoCuentaEnGestionCtasEPS en(String estado, String nroCuenta) {

		return new ValidoEstadoCuentaEnGestionCtasEPS(estado, nroCuenta);
	}
}
