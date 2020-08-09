package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FacturaInformacionComplementariaPage {

	public static final Target INFORMACION_COMPLEMNENTARIA = Target.the("Información Complementaria")
			.locatedBy("//Button[@type='submit']/span[.='Información complementaria']");

	public static final Target BUSCAR_DIAGNOSTICO = Target.the("Buscar diagnostico")
			.locatedBy("//Button[@type='submit'and @title='Asignar o cambiar Diagnóstico']/span[1]");
	public static final Target CODIGO_DIAGNOSTICO = Target.the("Cod Diagnostico")
			.locatedBy("//input[contains(@id,'busquedaDiagnosticoId:codigo')]");
	public static final Target REGISTRO_SELECCION = Target.the("Seleccionar diagnostico {0}")
			.locatedBy("//td[contains(text(),'{0}')][1]/ancestor::tr");
	public static final Target APLICA_PBS = Target.the("Aplica PBS {0}")
			.locatedBy("//div[contains(@id,'cobertura')]//span[.='{0}']");
	public static final Target BUSCAR_CENTRO_DE_COSTO = Target.the("Buscar Centro de Costo")
			.locatedBy("//Button[@type='submit'and @title='Asignar o cambiar Centro de costo']/span[1]");
	public static final Target CENTRO_DE_COSTO = Target.the("Centro de costo ")
			.locatedBy("//input[contains(@id,'busquedaDiagnosticoId:descripcion')]");

	public static final Target ALTO_COSTO = Target.the("Alto costo {0}")
			.locatedBy("//div[contains(@id,'altocosto')]//span[.='{0}']");
	public static final Target APLICA_NOPBS = Target.the("Aplica NOPBS {0}")
			.locatedBy("//div[contains(@id,'tutela')]//span[.='{0}']");
}
