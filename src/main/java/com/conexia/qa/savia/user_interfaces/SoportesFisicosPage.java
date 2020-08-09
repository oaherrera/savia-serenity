package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SoportesFisicosPage {

	public static final Target ADJUNTAR_ARCHIVO = Target.the("Adjuntar Archivo")
			.locatedBy("//input[contains(@id,'soportesFisicosRecibidosId:fileUpload_input')]");
	public static final Target TIPO_DE_DOCUMENTO = Target.the("Tipo de Archivo")
			.locatedBy("//label[contains(@id,':tipoArchivoId_label')]");
	public static final Target TIPO_DE_DOCUMENTO_SELECCION = Target.the("Tipo de Archivo")
			.locatedBy("//li[contains(@id,':tipoArchivoId_')and text()='{0}']");
	public static final Target AGREGAR = Target.the("Agregar")
			.locatedBy("//button[contains(@id,':btnAgregarTipoArchivo')]");
	public static final Target OBSERVACIONES = Target.the("Observaciones")
			.locatedBy("//textarea[contains(@id,'soportesFisicosRecibidosId')]");

}
