package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class BandejaPrestadorNegociacionPage {

	public static final Target FILTRO_NOMBRE = Target.the("Filtrar por nombre")
			.locatedBy("//thead[contains(@id,'PrestadoresGral_head')]/tr/th/span[.=' Nombre']//following::input[1]");
	public static final Target VER_NEGOCIACIONES = Target.the("Ver Negociaciones")
			.locatedBy("(//button[@title='Ver Negociaciones del Prestador'])[1]");

}
