package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class GestionCuentasEpsFacturasPage {
	public static final Target MARCAR_TAOAS = Target.the("Macar todas las factura")
			.locatedBy("(//span[.='Marcar todos']/following::div/span)[1]");
	public static final Target MARCAR_REVISADO = Target.the("Macar revisado").locatedBy("//span[.='Marcar Revisado']");
	public static final Target ACEPTAR = Target.the("Aceptar")
			.locatedBy("//div[contains(@style,'display: block')]/div//span[.='Aceptar']");
	public static final Target CUENTA_REVISADA = Target.the("Cuenta Revisada").locatedBy("//span[.='Cuenta Revisada']");
}
