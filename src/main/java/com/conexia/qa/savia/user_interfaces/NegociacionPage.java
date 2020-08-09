package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class NegociacionPage {

	public static final Target CREAR_NEGOCIACION = Target.the("Crear Negociacion")
			.locatedBy("//button[@type='submit']/span[.='Crear negociación']");
	public static final Target NUMERO_NEGOCIACION_FILTRO = Target.the("N° Negociacion tabla filtro")
			.locatedBy("//thead[contains(@id,'negociacionesPrestador_head')]/tr/th[.='No. Negociación']/child::input");
	public static final Target VER_NEGOCIACION = Target.the("Ver negociacion")
			.locatedBy("//button[contains(@id,'btnVerNegociacion')]");
	public static final Target TABLA_ENCABEZADO = Target.the("Tabla Encabezado").locatedBy(
			"//div[@class='ui-scrollpanel ui-scrollpanel-native ui-widget ui-widget-content ui-corner-all']");

	// Crear Negociación
	public static final Target MODALIDAD_NEGOCIACION = Target.the("Modalidad Negociacion")
			.locatedBy("//label[contains(@id,'modalidadNegociacion_label')]");
	public static final Target MODALIDAD_NEGOCIACION_SELECCION = Target.the("Modalidad Negociacion {0}")
			.locatedBy("//div[contains(@id,'modalidadNegociacion_panel')]//li[@data-label='{0}']");
	public static final Target REGIMEN_NEGOCIACION = Target.the("Regimen Negociacion")
			.locatedBy("//label[contains(@id,'regimenNegociacion_label')]");
	public static final Target MODALIDAD_REGIMEN_SELECCION = Target.the("Regimen Negociacion {0}")
			.locatedBy("//div[contains(@id,'regimenNegociacion_panel')]//li[@data-label='{0}']");
	public static final Target POBLACION = Target.the("Poblacion")
			.locatedBy("//input[contains(@id,'poblacionNegociacion')]");
	public static final Target COMPLEJIDAD = Target.the("Complejidad")
			.locatedBy("//label[contains(@id,'complejidadNegociacion_label')]");
	public static final Target COMPLEJIDAD_SELECCION = Target.the("Complejidad {0}")
			.locatedBy("//div[contains(@id,'complejidadNegociacion_panel')]//li[@data-label='{0}']");
	public static final Target AREA_DE_COBERTURA = Target.the("Area de cobertura")
			.locatedBy("//label[contains(@id,'listOpcionesArea_label')]");
	public static final Target AREA_DE_COBERTURA_SELECCION = Target.the("Area de cobertura {0}")
			.locatedBy("//div[contains(@id,'listOpcionesArea_panel')]//li[@data-label='{0}']");

}
