package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InsumoPage {

	public static Target TAB_INSUMOS = Target.the("Tab de Insumos")
			.locatedBy("(//a[contains(@href,'prescripciones:tabs:')][.='Insumos'])[1]");
	public static Target ID_DESCRIPCION_UNSUMO = Target.the("Id o Description Insumo")
			.locatedBy("//input[contains(@id,'InsumosPrescripcion:campoAutocomplete2_input')]");
	public static Target ID_DESCRIPCION_UNSUMO_SELECT = Target.the("Id o Description Insumo")
			.locatedBy("//li[@data-item-label='{0}']");
	public static Target DIAGNOSTICO = Target.the("Diagnostico")
			.locatedBy("(//select[contains(@id,'listaInsumosPrescripcion:insumosTable:0:')])[2]");
	public static Target DIAGNOSTICO_SELECT = Target.the("Diagnostico")
			.locatedBy("(//select[contains(@id,':insumosTable:0:')])[2]/option[contains(text(),'{0}')]");
	public static Target AGREGAR_INSUMO = Target.the("Agregar Isumo")
			.locatedBy("//a[contains(@id,'insumos') and @title= 'Agregar prescripción insumo']");
	public static Target DURACION_TRATAMIENTO = Target.the("Duración del trtamiento")
			.locatedBy("//input[contains(@id,'duracionTratamientoId2_input')]");
	public static Target GUARDAR = Target.the("Guardar Isumo")
			.locatedBy("//button[contains(@id,'btnAceptarPrescripcion')]/span[text()='Guardar']");

}
