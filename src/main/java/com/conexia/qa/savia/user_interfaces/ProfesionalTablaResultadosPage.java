package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProfesionalTablaResultadosPage {

	public static final Target SELECCIONAR_PROFESIONAL = Target.the("Seleccionar profesional {0}")
			.locatedBy("//tbody[contains(@id,'tableResultProfesionalId_data')]/tr[{0}]/td[1]");

}
