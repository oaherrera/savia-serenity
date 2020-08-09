package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FormularioGestionDeCuentasValidadasPage {
	public static final Target IPS = Target.the("Ips").locatedBy("//input[contains(@id,':prestadorIps_input')]");
	public static final Target IPS_SELECCION = Target.the("Ips").locatedBy("//li[@data-item-label='{0}']");
	public static final Target NUMERO_DE_CUENTA = Target.the("Numero de cuenta")
			.locatedBy("//input[@id='formBuscarCuentas:noCuenta']");
	public static final Target BUSCAR = Target.the("Buscar")
			.locatedBy("//button[contains(@id,'formBuscarCuentas:')]//self::span[contains(text(),'Buscar')]");
	public static final Target BOTON_BUSCAR_GESTIONCTASEPS = Target.the("Buscar")
			.locatedBy("(//button[contains(@id,'formBuscarCuentas:')]//self::span[contains(text(),'Buscar')])[2]");
}
