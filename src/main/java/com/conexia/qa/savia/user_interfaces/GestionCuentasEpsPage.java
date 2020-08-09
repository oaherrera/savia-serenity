package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class GestionCuentasEpsPage {

	public static final Target ACCION = Target.the("[0]")
			.locatedBy("//button[@title='{0}']/span[1]");
}
