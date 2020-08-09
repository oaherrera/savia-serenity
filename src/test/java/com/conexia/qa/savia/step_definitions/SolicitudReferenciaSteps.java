package com.conexia.qa.savia.step_definitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.conexia.qa.savia.interactions.AbrirOpcion;
import com.conexia.qa.savia.tasks.BuscarAfiliado;

import cucumber.api.java.en.Given;

public class SolicitudReferenciaSteps {

	@Given("^Consulto afiliado con (.+) Nro (.+) en el modulo de Referencia$")
	public void consultoAfiliadoConTipoDocumentoNro(String tipoDocumento, String numeroDocumento) {
		theActorInTheSpotlight().attemptsTo(AbrirOpcion.delMenu("Solicitud autorización", "Solicitud"));
		theActorInTheSpotlight().attemptsTo(BuscarAfiliado.porTipoidentificacion(tipoDocumento, numeroDocumento));
	}

}
