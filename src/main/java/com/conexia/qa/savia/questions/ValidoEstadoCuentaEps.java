package com.conexia.qa.savia.questions;

import static com.conexia.qa.savia.user_interfaces.ResultadoGestionDeCuentasEpsPage.ESTADO;
import static com.conexia.qa.savia.user_interfaces.ResultadoGestionDeCuentasEpsPage.NUMERO_CUENTA;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidoEstadoCuentaEps implements Question<Boolean> {

	private String estado;
	private String nroCuenta;

	public ValidoEstadoCuentaEps(String estado, String nroCuenta) {
		this.estado = estado;
		this.nroCuenta = nroCuenta;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		takeScreenshot();
		 if(!NUMERO_CUENTA.of(nroCuenta).resolveFor(actor).isVisible()) {
			 System.out.println("Numero cuenta");
			 takeScreenshot();
			 return false;
		 }else if(!ESTADO.of(estado).resolveFor(actor).isVisible()) {
			 System.out.println("Estado");
			 takeScreenshot();
			 return false;
		 }
		 takeScreenshot();
		return true;
	}

	public static ValidoEstadoCuentaEps en(String estado, String nroCuenta) {

		return new ValidoEstadoCuentaEps(estado, nroCuenta);
	}
}
