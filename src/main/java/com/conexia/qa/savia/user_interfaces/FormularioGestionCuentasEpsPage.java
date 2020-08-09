package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FormularioGestionCuentasEpsPage {

	public static final Target NUMERO_CUENTA = Target.the("Numero de Cuenta")
			.locatedBy("//input[@id='formBuscarCuentas:noCuenta']");
	public static final Target BUSCAR = Target.the("Buscar")
			.locatedBy("//button[@id='formBuscarCuentas:btnBuscar']/span[1]");

}
