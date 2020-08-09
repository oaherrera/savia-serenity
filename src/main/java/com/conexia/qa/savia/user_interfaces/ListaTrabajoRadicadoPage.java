package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ListaTrabajoRadicadoPage {
	// input filtros
	public static final Target FILTRAR_POR_ = Target.the("filtrar por:{0}")
			.locatedBy("(//th[contains(@id,'listaTrabajo')]/span[.='{0}'])/following::input[1]");

	public static final Target VER_DETALLE = Target.the("Ver Detalle")
			.locatedBy("(//button[contains(@id,'listaTrabajo:0:detalle')])/span[1]");

	public static final Target ESTADO_RADICADO = Target.the("Estado Radicado")
			.locatedBy("//tbody[contains(@id,'listaTrabajo_data')]/tr/td[8 and .='{0}']");

	public static final Target ASIGNAR = Target.the("Asignar")
			.locatedBy("(//button[contains(@id,'listaTrabajo:0:asignar')])/span[1]");

	public static final Target FINALIZAR_AUDITORIA = Target.the("Finalizar Auditoria")
			.locatedBy("(//button[contains(@id,'listaTrabajo:0:finalizar')])/span[1]");

	public static final Target CONFIRMAR_CERRAR_CUENTA = Target.the("Confirmar Cerrar Cuenta")
			.locatedBy("//button[@type='submit']/span[.='Confirmar cerrar cuenta']");
}
