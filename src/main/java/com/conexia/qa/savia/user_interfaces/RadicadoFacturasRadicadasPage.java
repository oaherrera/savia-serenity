package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class RadicadoFacturasRadicadasPage {

	public static final Target MARCAR_TODOS = Target.the("Marcar todos")
			.locatedBy("(//span[.='Marcar todos']/following::div/span)[1]");
	public static final Target MARCAR_COMO_REVISADO = Target.the("Marca como Revisado")
			.locatedBy("//Button[@type='submit']/span[.='Marcar como revisado']");
	public static final Target TABLA_ENCABEZADO = Target.the("Tabla")
			.locatedBy("//div[@class='ui-datatable-scrollable-header-box']");
}
