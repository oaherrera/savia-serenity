package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ImprimirTicket {
	public static final Target MENSAJE_EJECUTO_CORRECTAMENTE = Target.the("Se ejecuto exitosamente")
			.locatedBy("//span[.='La transacción fue ejecutada exitosamente.']");
	
}
