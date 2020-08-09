package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProfesionalPage {
	public static final Target PRIMER_NOMBRE = Target.the("Primer Nombre ")
			.locatedBy("//input[contains(@id,'tabNombres:primerNombre')]");
	public static final Target SEGUNDO_NOMBRE = Target.the("Segundo Nombre ")
			.locatedBy("//input[contains(@id,'tabNombres:segundoNombre')]");
	public static final Target PRIMER_APELLIDO = Target.the("Primer Apellido")
			.locatedBy("//input[contains(@id,'tabNombres:primerApellido')]");
	public static final Target SEGUNDO_APELLIDO = Target.the("Segundo Apellido")
			.locatedBy("//input[contains(@id,'tabNombres:segundoApellidos')]");
	public static final Target TIPO_DE_DOCUMENTO = Target.the("Tipo de Documento")
			.locatedBy("//label[contains(@id,'tabNombres:tipoDoc:selectEnum_label')]");
	public static final Target TIPO_DE_DOCUMENTO_SELECCION = Target.the("Tipo de Documento")
			.locatedBy("//li[contains(@id,'tabNombres:tipoDoc:selectEnum_')][.='{0}']");
	public static final Target NUMERO_DE_DOCUMENTO = Target.the("Numero de Documento")
			.locatedBy("//input[contains(@id,'tabNombres:numDoc')]");
	public static final Target ESPECIALIDAD = Target.the("Especialidad")
			.locatedBy("//label[contains(@id,'tabNombres:especialidad_label')]");
	public static final Target ESPECIALIDAD_SELECCION = Target.the("Especialidad")
			.locatedBy("//li[contains(@id,'tabNombres:especialidad_')][.={0}]");
	public static final Target CARGO = Target.the("Cargo")
			.locatedBy("//label[contains(@id,'tabNombres:cargo_label')]");
	public static final Target CARGO_SELECCION = Target.the("Cargo")
			.locatedBy("//li[contains(@id,'datosProfesional:tabNombres:cargo_')][.={0}]");
	public static final Target TELEFONO = Target.the("Telfono")
			.locatedBy("//input[contains(@id,'tabNombres:telefono')]");
	public static final Target CELULAR = Target.the("Celular").locatedBy("//input[contains(@id,'tabNombres:celular')]");
	public static final Target BUSCAR = Target.the("Buscar")
			.locatedBy("//button[contains(@id,'tabNombres:btnBuscarProfesional')]");
	public static final Target LIMPIAR = Target.the("Limpiar").locatedBy("//span[contains(text(),'Limpiar')]");

}
