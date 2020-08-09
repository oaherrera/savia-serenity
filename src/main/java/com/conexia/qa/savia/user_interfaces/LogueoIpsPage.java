package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LogueoIpsPage {

	public static final Target BUSCAR_POR_NIT = Target.the("Buscar Por Nit ")
			.locatedBy("//label[contains(text(),'Buscar por NIT')]");
	public static final Target BUSCAR_POR_RAZON_SOCIAL = Target.the("Buscar por Razon Social ")
			.locatedBy("//label[contains(text(),'Buscar por Razón social')]");
	public static final Target INPUT_RAZON_SOCIAL = Target.the("Razon Social ")
			.locatedBy("//input[contains(@id,'prestador_input')]");
	public static final Target RAZON_SOCIAL_SELECCION = Target.the("Razon social {0}")
			.locatedBy("//li[@role='option' and @data-item-label='{0}']");
	public static final Target GESTION_CUENTAS = Target.the("Gestion Cuentas ")
			.locatedBy("//label[contains(text(),'Gestión de Cuentas')]");
	public static final Target VALIDAR_RIPS = Target.the("Validar Rips").locatedBy(
			"//label[contains(text(),'Validar RIPS')]");
	public static final Target DIGITAT_CUENTA_MANUAL = Target.the("Digitar Cuenta Manual")
			.locatedBy("//label[contains(text(),'Digitar Cuenta Manual')]");
	public static final Target BOTON_INGRESAR = Target.the("Boton Ingresar")
			.locatedBy("//button[@type='submit']/span[.='Ingresar']");

}
