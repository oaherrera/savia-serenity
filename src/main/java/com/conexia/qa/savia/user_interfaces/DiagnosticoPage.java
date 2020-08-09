package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DiagnosticoPage {
	public static final Target DIAGNOSTICO = Target.the("Codigo o Descripcion del diagnostico")
			.locatedBy("//input[contains(@id,'busquedaComposite:campoAutocomplete5_input')]");
	public static final Target DIAGNOSTICO_SELECCION = Target.the("Codigo o Descripcion del diagnostico")
			.locatedBy("//div[contains(@id,'campoAutocomplete5_panel')]/ul/li[1]");
	public static final Target TIPO = Target.the("Tipo ")
			.locatedBy("//label[contains(@id,'tipoDiagnostico:selectEnum_label')]");
	public static final Target TIPO_SELECCION = Target.the("Tipo ")
			.locatedBy("//li[contains(@id,'tipoDiagnostico:selectEnum_1')]");

}
