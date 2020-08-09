package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class RadicadoGestionRadicadoPage {

	public static final Target CERRAR_CUENTA = Target.the("Cerrar Cuenta")
			.locatedBy("//button[@type='submit' ]/span[.='Cerrar cuenta']");
	public static final Target CONFIRMAR_CIERRE_CUENTA = Target.the("Confirmar Cierre de Cuenta")
			.locatedBy("//button[@type='submit' ]/span[.='Confirmar cerrar cuenta']");
}
