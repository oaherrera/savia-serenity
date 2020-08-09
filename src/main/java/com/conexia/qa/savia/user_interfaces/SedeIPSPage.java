package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SedeIPSPage {
	public static final Target TIPO_DE_DOCUMENTO = Target.the("Tipo de Documento ")
			.locatedBy("//label[contains(@id,'informaicionIpsId:tipoDoc:selectEnum_label')]");
	public static final Target TIPO_DE_DOCUMENTO_SELECCION = Target.the("Tipo de Documento ")
			.locatedBy("//li[contains(@id,'informaicionIpsId:tipoDoc:selectEnum_')][.={0}]");
	public static final Target NUMERO_DE_DOCUMENTO = Target.the("numero de Documento")
			.locatedBy("//label[text()='Número de documento' and contains(@id,'IpsId:')]//following::input[1]");
	public static final Target RAZON_SOCIAL = Target.the("Razon social")
			.locatedBy("//label[text()='Razón social' and contains(@id,'IpsId:')]//following::input[1]");
	public static final Target DEPARTAMENTO = Target.the("Deparamento")
			.locatedBy("//label[contains(@id,'departamento_label')]");
	public static final Target DEPARTAMENTO_SELECCION = Target.the("Departamento")
			.locatedBy("//li[contains(@id,'departamento_')][.={0}]");
	public static final Target MUNICIPIO = Target.the("Municipio")
			.locatedBy("//label[contains(@id,'municipio_label')]");
	public static final Target MUNICIPIO_SELECCION = Target.the("Municipio")
			.locatedBy("//li[contains(@id,'municipio_')][.={0}]");
	public static final Target DIRECCION = Target.the("Direccion").locatedBy("//input[contains(@id,'direccionIpsId')]");
	public static final Target BUSCAR = Target.the("Buscar").locatedBy("//button[contains(@id,'btnBuscarIps')]");
	public static final Target LIMPIAR = Target.the("Limpiar").locatedBy("//button[contains(@id,'btnLimpiarIps')]");
	public static final Target CAMBIAR = Target.the("Cambiar").locatedBy("//button[contains(@id,'btnCambiarIps')]");
	public static final Target TABLA_DE_SEDES = Target.the("Tabla de sedes")
			.locatedBy("//tbody[contains(@id,'sedesIpsTableId_data')]/tr[2]/td[2]");

}
