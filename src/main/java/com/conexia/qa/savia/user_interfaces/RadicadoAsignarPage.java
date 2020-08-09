package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class RadicadoAsignarPage {

	public static final Target REGIONAL = Target.the("Regional")
			.locatedBy("//label[contains(@id,'commSecAsignarFact:regional_label')]");
	public static final Target REGIONAL_SELECCION = Target.the("Regional {0}")
			.locatedBy("//li[contains(@id,'commSecAsignarFact:regional_') and .='{0}']");
	public static final Target CARGO = Target.the("Cargo")
			.locatedBy("//label[contains(@id,'commSecAsignarFact:cargo_label')]");
	public static final Target CARGO_SELECCION = Target.the("Cargo {0}")
			.locatedBy("//li[contains(@id,'commSecAsignarFact:cargo_') and .='{0}']");
	public static final Target NOMBRE = Target.the("Nombre")
			.locatedBy("//input[contains(@id,'commSecAsignarFact:nombre_input')]");
	public static final Target NOMBRE_SELECCION = Target.the("Nombre {0}")
			.locatedBy("//li[contains(@class,'ui-autocomplete-item') and contains(@data-item-label,'{0}')]");
	public static final Target ASIGNAR = Target.the("Asignar").locatedBy("");

	public static final Target MARCAR = Target.the("Marcar {0}").locatedBy(
			"(//tbody/tr/td[.='{0}']/following::div/div[not(contains(@class,'ui-state-disabled'))]/span)[1]");

	public static final Target ASIGNACION_ACTUAL_NOMBRE = Target.the("Nombre Asignación Actual {0}")
			.locatedBy("//tbody[contains(@id,'tblUsuariosAsignados_data')]/tr/td[.='{0}'][1]");
}
