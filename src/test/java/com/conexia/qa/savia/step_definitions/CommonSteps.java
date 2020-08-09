package com.conexia.qa.savia.step_definitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.conexia.qa.savia.interactions.Volver;

import cucumber.api.java.en.And;

public class CommonSteps {

	@And("Vuelvo al formulario anterior")
	public void vuelvoAlFormularioAnterior() {
		theActorInTheSpotlight().attemptsTo(Volver.alFormularioAnterior());
	}
}
