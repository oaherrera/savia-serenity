package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class AcompañantePage {

	public static final Target NOMBRE = Target.the("Nombre ")
			.locatedBy("//label[text()='Nombre Completo']//following::input[1]");
	public static final Target TELEFONO_FIJO = Target.the("Nombre ")
			.locatedBy("//label[text()='Teléfono fijo' and contains(@id,'Acompaniante')]//following::input[1]");
	public static final Target CELULAR = Target.the("Nombre ")
			.locatedBy("//label[text()='Celular' and contains(@id,'Acompaniante')]//following::input[1]");
}
