package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ConfirmarDerechosPage {

	public static final Target TIPO_DOCUMENTO = Target.the("Tipo Documento ")
			.locatedBy("//label[contains(@id,'tipoDoc:selectEnum_label')]");
	public static final Target TIPO_DOCUMENTO_OPCION = Target.the("Opcion Tipo Documento")
			.locatedBy("//li[contains(@id,'tipoDoc:selectEnum')][.='{0}']");
	public static final Target NUMERO_DOCUMENTO = Target.the("Numero de documento")
			.locatedBy("//input[contains(@id,'tabDoc:numDoc')]");
	public static final Target BUSCAR = Target.the("Buscar")
			.locatedBy("//button[contains(@id,'searchAfiliadoTabs:tabDoc:btnSearch')]");
	public static final Target ACEPTAR = Target.the("ACEPTAR").locatedBy("//span[text()='Aceptar']");
}