package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class MedicamentoPage {

	public static final Target TAB_DE_MEDICAMENTOS = Target.the("Tab de medicamentos")
			.locatedBy("(//a[contains(@href,'prescripciones:tabs:')][.='Medicamentos'])[1]");
	public static final Target CODIGO_DESCRIPCION = Target.the("Codigo o Descripcion del medicamento")
			.locatedBy("//input[contains(@id,'busquedaMedicamentos:campoAutocomplete3_input')]");
	public static final Target CODIGO_DESCRIPCION_SELECCION = Target.the("Seleccionar Codigo del mendicamento")
			.locatedBy("//li[contains(@class,'ui-autocomplete-list-item') and @data-item-label='{0}']/span[1]");
	public static final Target SERVICIO = Target.the("Servicio")
			.locatedBy("(//select[contains(@id,'listaMedicamentos:medicamentosTable:0:')])[2]");
	public static final Target SERVICIO_SELECCION = Target.the("Servicio Seleccionado")
			.locatedBy("(//option[contains(text(),'{0}')])[2]");
	public static final Target ADVERTENCIA_NO_ELIMINAR_MEDICAMENTO = Target.the("Advertencia no eliminar medicamento")
			.locatedBy("//button[contains(@id,'btnContinuar')]/span[.='No']");
	public static final Target AGREGAR_PRESCRIPCION_MEDICAMENTO = Target.the("Agregar prescripcion medicamento")
			.locatedBy("//a[contains(@title,'Agregar prescripción medicamento')]");
	public static final Target CAUSA_EXTERNA = Target.the("Seleccionar Causa Externa")
			.locatedBy("//label[contains(@id,':causaExterna_label')]");
	public static final Target CAUSA_EXTERNA_SELECCION = Target.the("Seleccionar Causa Externa")
			.locatedBy("//li[contains(@id,':causaExterna_')][.='{0}']");
	public static final Target FINALIDAD = Target.the("Seleccionar Finalidad")
			.locatedBy("//label[contains(@id,':finalidad_label')]");
	public static final Target FINALIDAD_SELECCION = Target.the("Seleccionar Finalidad")
			.locatedBy("//li[contains(@id,':finalidad_')][.='{0}']");
	public static final Target TIPO_CATASTROFICO = Target.the("Seleccionar Tipo Catastrofico")
			.locatedBy("//label[contains(@id,':tipoCatastrofico')]");
	public static final Target TIPO_CATASTROFICO_SELECCION = Target.the("Seleccionar Tipo Catastrofico")
			.locatedBy("//LI[contains(@id,':tipoCatastrofico_')][.='{0}']");
	public static final Target DOSIS = Target.the("Dpsis").locatedBy("(//label[.='Dosis'])/following::input[1]");
	public static final Target FRECUENCIA = Target.the("Frecuencia")
			.locatedBy("(//label[.='Frecuencia'])/following::input[1]");
	public static final Target FRECUENCIA_TIPO = Target.the("Frecuencia tipo")
			.locatedBy("//label[contains(@id,'tipoFrecuencia_label')]");
	public static final Target FRECUENCIA_TIPO_SELECCION = Target.the("Frecuencia tipo")
			.locatedBy("//li[contains(@id,'tipoFrecuencia_')][.='{0}']");
	public static final Target VIA_DE_ADMINISTRACION = Target.the("Via de Administración")
			.locatedBy("//label[contains(@id,'viaAdministracion:selectEnum_label')]");
	public static final Target VIA_DE_ADMINISTRACION_SELECCION = Target.the("Via de Administración")
			.locatedBy("//li[contains(@id,'viaAdministracion:selectEnum_')][.='{0}']");// 
	public static final Target DURACION_TRATAMIENTO_DIAS = Target.the("Duración del tratamiendo en dias")
			.locatedBy("//input[contains(@id,'duracionTratamientoMedicamentoId2_input')]");
	public static final Target POSOLOGIA = Target.the("Posología")
			.locatedBy("//label[text()='Posología']/following::textarea[1]");
	public static final Target GUARDAR = Target.the("Guardar")
			.locatedBy("//button[contains(@id,'btnAceptarPrescripcion')]");

}
