package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HistoriaClinicaPage {

	public static final Target FECHA_DESDE = Target.the("Fecha desde")
			.locatedBy("//input[contains(@id,'calendarioInicioId_input')]");
	public static final Target HOY = Target.the("Desde Dia de hoy")
			.locatedBy("//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-today']");
	public static final Target FECHA_HASTA = Target.the("Fecha hasta")
			.locatedBy("//input[contains(@id,'calendarioFinId_input')]");
	public static final Target EVALUACION = Target.the("Evaluación")
			.locatedBy("//textarea[contains(@id,'form:histClinica:historiaClinicaId')]");

}
