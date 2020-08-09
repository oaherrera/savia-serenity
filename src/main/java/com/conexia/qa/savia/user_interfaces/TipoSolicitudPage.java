package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class TipoSolicitudPage {
	
	public static final Target SERVICIO_DE_ATENCION = Target.the("Servicio de Atencion")
			.locatedBy("//label[contains(@id,'cabeceraComposite:servicios_label')]");
	public static final Target SERVICIO_DE_ATENCION_SELECCION = Target.the("Selección Servicio de Atencion")
			.locatedBy("//li[contains(@id,'cabeceraComposite:servicios_')][.='{0}']");
	public static final Target PROGRAMA = Target.the("Programa ")
			.locatedBy("//label[contains(@id,'tipoSolicitudCxId:programaId_label')]");
	public static final Target PROGRAMA_SELECCION = Target.the("Selección del programa")
			.locatedBy("//li[contains(@id,'tipoSolicitudCxId:programaId_')][.='{0}']");

}
