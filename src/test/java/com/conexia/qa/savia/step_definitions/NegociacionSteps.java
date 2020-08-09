package com.conexia.qa.savia.step_definitions;

import static com.conexia.qa.savia.models.MensajeTemporal.traerMensaje;
import static com.conexia.qa.savia.models.NegociacionPrestador.guardarNegociacionPrestador;
import static com.conexia.qa.savia.models.NegociacionPrestador.limpioDatosNegociacionPrestador;
import static com.conexia.qa.savia.models.NegociacionPrestador.traerNegociacionPrestador;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.List;

import com.conexia.qa.savia.models.NegociacionPrestador;
import com.conexia.qa.savia.questions.MensajeTemporal;
import com.conexia.qa.savia.tasks.BuscoAlPrestadorNegociacion;
import com.conexia.qa.savia.tasks.ConsultoNegociacion;
import com.conexia.qa.savia.tasks.CreaLaBaseDeNegociacion;
import com.conexia.qa.savia.utilitarios.ExtraerExprexion;

import static org.hamcrest.Matchers.containsString;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NegociacionSteps {

	@When("^Busco al prestador (.+) para (.+).$")
	public void buscoAlPrestadorPara(String nombreprestador, String realizarAccionAlBuscar) {
		theActorInTheSpotlight().attemptsTo(BuscoAlPrestadorNegociacion.porNombre(nombreprestador));
		theActorInTheSpotlight().attemptsTo(BuscoAlPrestadorNegociacion.para(realizarAccionAlBuscar));
	}

	@When("^Creo la base negociacion$")
	public void creoLaBaseNegociacion(List<NegociacionPrestador> datosNegociacionPrestador) {
		limpioDatosNegociacionPrestador();
		guardarNegociacionPrestador(datosNegociacionPrestador.get(0));
		theActorInTheSpotlight().attemptsTo(CreaLaBaseDeNegociacion.conLosDatos());
	}

	@Then("^Negociación creada correctamente$")
	public void negociaciónCreadaCorrectamente() {
		theActorInTheSpotlight()
				.should(seeThat(MensajeTemporal.es(), containsString("Negociación creada correctamente")));
		traerNegociacionPrestador()
				.setNumeroNegociacion(ExtraerExprexion.deUnTexto(traerMensaje(), ".*, No (.*)", 1).trim());
	}

	@And("^Consulto la negociacion numero: (\\d+), para (.+)$")
	public void consultoLaNegociacionNumeroParaVerNegociacion(int numeroNegociacion, String accionAlBuscar) {
		if (traerNegociacionPrestador() != null && traerNegociacionPrestador().getNumeroNegociacion() != null) {
			numeroNegociacion = Integer.parseInt(traerNegociacionPrestador().getNumeroNegociacion());
		}
		theActorInTheSpotlight().attemptsTo(ConsultoNegociacion.porNumeroDeNegocacion("" + numeroNegociacion));
		theActorInTheSpotlight().attemptsTo(ConsultoNegociacion.para(accionAlBuscar));
	}

	

}
