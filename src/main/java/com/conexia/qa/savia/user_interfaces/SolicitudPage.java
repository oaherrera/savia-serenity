package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SolicitudPage {
	public static final Target NUMERO_SOLICITUD = Target.the("Numero Solicitud ")
			.locatedBy("//input[contains(@id,'datosSolicitud:numeroSolicitudId_input')]");
	public static final Target JUSTIFICACION_CLINICA = Target.the("Justificaion Clinica")
			.locatedBy("//textarea[contains(@id,':justificacionClinicaId:')]");
	public static final Target VALIDAR = Target.the("Validar ").locatedBy("//span[text()='Validar']");
	public static final Target NUMERO_DE_TICKET = Target.the("Numero de ticket")
			.locatedBy("//td[contains(text(),'TicketSolicitudAutorizacion')]");

}
