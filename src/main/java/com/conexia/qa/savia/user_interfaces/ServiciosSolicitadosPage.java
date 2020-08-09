package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ServiciosSolicitadosPage {
	public static final Target ORIGEN_DE_LA_ATENCION = Target.the("Origen de la Atención")
			.locatedBy("//label[contains(@id,'origenAtencionId:selectEnum_label')]");
	public static final Target ORIGEN_DE_LA_ATENCION_SELECCION = Target.the("Origen de la Atención")
			.locatedBy("//li[contains(@id,'origenAtencionId:selectEnum_')][.='{0}']");
	public static final Target PRIORIDAD_DE_LA_aTENCION = Target.the("Prioridad de la Atención")
			.locatedBy("//label[contains(@id,'prioridadAtencionId:selectEnum_label')]");
	public static final Target PRIORIDAD_DE_LA_aTENCION_SELECCION = Target.the("Prioridad de la Atención")
			.locatedBy("//li[contains(@id,'prioridadAtencionId:selectEnum_')][.='{0}']");
	public static final Target TIPO_SERVICIO_SOLICITADO = Target.the("Tipo servicio solicitado")
			.locatedBy("//label[contains(@id,':tipoServicioId_label')]");
	public static final Target TIPO_SERVICIO_SOLICITADO_SELECCION = Target.the("Tipo servicio solicitado")
			.locatedBy("//li[contains(@id,'tipoServicioId_')][.='{0}']");
	public static final Target UBICACION_DEL_PACIENTE = Target.the("Ubicación del paciente")
			.locatedBy("//label[contains(@id,'ubicacionPacienteId_label')]");
	public static final Target UBICACION_DEL_PACIENTE_SELECCION = Target.the("Ubicación del paciente")
			.locatedBy("//li[contains(@id,'ubicacionPacienteId_')][.='{0}']");

}
