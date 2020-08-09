package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProcedimientoPage {

	public static final Target PROCEDIMIENTO_CODIGO = Target.the("Codigo o Descripcion procedimiento ") 
			.locatedBy("//input[contains(@id,'campoAutocomplete1_input')]");
	public static final Target PROCEDIMIENTO_CODIGO_SELECCION = Target.the("Codigo o Descripcion procedimiento ")
			.locatedBy("//div[contains(@id,':campoAutocomplete1_panel')]/ul/li[1]");
	public static final Target SERVICIO = Target.the("Servicio")
			.locatedBy("//select[contains(@id,'procedimientosTable:0:servicio')]");
	public static final Target SERVICIO_SELECCION = Target.the("Servicio")
			.locatedBy("//*[contains(@id,'procedimientosTable:0:servicio')]/option[2]");
	public static final Target CANTIDAD = Target.the("Cantidad ")
			.locatedBy("//*[contains(@id,'procedimientosTable:0')]/input[1]");
	public static final Target DIAGNOSTICO = Target.the("Diagnosctico")
			.locatedBy("//tbody[contains(@id,'procedimientosTable')]/tr[1]/td[9]/select");
	public static final Target DIAGNOSTICO_SELECCION = Target.the("Diagnostico")
			.locatedBy("//tbody[contains(@id,'procedimientosTable')]/tr[1]/td[9]/select/option[2]");
	public static final Target PREQUIRURGICO = Target.the("Prequirurgico")
			.locatedBy("//tbody[contains(@id,'procedimientosTable')]/tr[1]/td[9]/div/div[2]/span");
	public static final Target AGREGAR = Target.the("Agregar")
			.locatedBy("//a[contains(@title,'Agregar') and contains(@id,'prescripcionesComposite')]");
	public static final Target ELIMINAR = Target.the("Eliminar")
			.locatedBy("//a[contains(@title,'Eliminar') and contains(@id,'prescripcionesComposite')]");
	public static final Target ES_POSFECHADO = Target.the("Es posfechado?")
			.locatedBy("//label[text()='¿Es posfechado?']//ancestor::div[1]/div/div[2]/span");
	public static final Target DURACION_DEL_TRATAMIENTO = Target.the("Duración del tratamiento")
			.locatedBy("//input[contains(@id,'duracionTratamientoId_input')]");
	public static final Target NUMERO_DE_ENTREGA = Target.the("Numero de Entrega")
			.locatedBy("//label[text()='Indicaciones']//following::textarea[1]");
	public static final Target INDICACIONES = Target.the("Indicaciones")
			.locatedBy("//label[text()='Indicaciones']//following::textarea[1]");
	public static final Target FECHA_DE_INGRESO = Target.the("Fecha de Ingreso")
			.locatedBy("//*[contains(@id,':fechaIngresoProcedimiento_input')]");
	public static final Target GUARDAR = Target.the("Guardar")
			.locatedBy("//Button[contains(@id,'btnAceptarPrescripcion')]");
	public static final Target CERRAR = Target.the("Cerrar").locatedBy("//*[contains(@id,':btnCancelarPrescripcion')]");

}
