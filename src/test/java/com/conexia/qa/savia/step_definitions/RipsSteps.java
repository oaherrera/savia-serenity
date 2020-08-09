package com.conexia.qa.savia.step_definitions;

import static com.conexia.qa.savia.models.InformacionValidarRips.guardarInformacion;
import static com.conexia.qa.savia.models.InformacionValidarRips.limpiarInformacionValidarRipsData;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.List;

import com.conexia.qa.savia.interactions.AbrirOpcion;
import com.conexia.qa.savia.interactions.AdjuntoArchivo;
import com.conexia.qa.savia.interactions.Esperar;
import com.conexia.qa.savia.models.InformacionValidarRips;
import com.conexia.qa.savia.questions.ValidoEstadoCuenta;
import com.conexia.qa.savia.questions.ValidoEstadoCuentaEnGestionCtasEPS;
import com.conexia.qa.savia.questions.ValidoEstadoCuentaEps;
import com.conexia.qa.savia.tasks.ConsultoEstadoCuenta;
import com.conexia.qa.savia.tasks.ConsultoEstadoCuentaComoEps;
import com.conexia.qa.savia.tasks.ConsultoEstadoCuentaGestionCuentasEPS;
import com.conexia.qa.savia.tasks.DiligencioFormularioValidacionCuentaRips;
import com.conexia.qa.savia.tasks.EnviarAHomologar;
import com.conexia.qa.savia.tasks.EnvioLaCargaRips;
import com.conexia.qa.savia.tasks.EpsRadicaCuenta;
import com.conexia.qa.savia.tasks.GestionoLaCuenta;
import com.conexia.qa.savia.tasks.GestionoLaCuentaComoEps;
import com.conexia.qa.savia.tasks.RealizaElLogueo;
import com.conexia.qa.savia.tasks.RealizaElLogueoParaValidarCta;
import com.conexia.qa.savia.tasks.marcoLaCuenta;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RipsSteps {

	@Given("^Ingreso al modulo de (.+), a (.+)$")
	public void ingresoAlModuloA(String modulo, String accionSubmoudlo) {
		theActorInTheSpotlight().attemptsTo(AbrirOpcion.delMenu(modulo, accionSubmoudlo));
	}

	@And("^Ingreso al logueo de la ips (.+)$")
	public void IngresoAlLogueoDeLaIps(String ips) {
		theActorInTheSpotlight().attemptsTo(RealizaElLogueo.deIps(ips));
	}

	@When("^Diligencio el formulario de Cargue y Vaidación de Rips$")
	public void diligencioElFormularioDeCargueYValidacionRips(List<InformacionValidarRips> InformacionValidarRipsData) {
		limpiarInformacionValidarRipsData();
		guardarInformacion(InformacionValidarRipsData.get(0));
		theActorInTheSpotlight().attemptsTo(DiligencioFormularioValidacionCuentaRips.conTodosLosDatos());
	}

	@And("^Adjunto el o los archivos de Rips y los Cargo$")
	public void adjuntoElOLosArchivosDeRipsYLosCargo(List<String> archivos) {
		System.out.println(archivos.get(1));
		int indice = 1;
		while (indice < archivos.size()) {
			theActorInTheSpotlight().attemptsTo(AdjuntoArchivo.con(archivos.get(indice), null));
			indice = indice + 1;
		}
		theActorInTheSpotlight().attemptsTo(EnvioLaCargaRips.paraGenerarCuentaValidada());
	}

	@And("^para Ingreso al logueo de la ips (.+) para validar la cuenta$")
	public void paraIngresoAlLogueoDeLaIpsParaValidarLaCuenta(String ips) {
		theActorInTheSpotlight().attemptsTo(RealizaElLogueoParaValidarCta.deIps(ips));

	}

	@And("^Consulto el estado de la cuenta (.+) gestionada para la ips$")
	public void consultoElEstadoDelaCuentaGestionada(String nroCuenta) {
		theActorInTheSpotlight().attemptsTo(ConsultoEstadoCuenta.conLaCuentaDeLaIps( nroCuenta));
	}
	
	
	@And("^Consulto el estado de la cuenta (.+) gestionada para la ips en gestion cuentas EPS$")
	public void consultoElEstadoDeLaCuentaGestionadaParaLaIpsEnGestionCuentasEPS(String nroCuenta) {
		theActorInTheSpotlight().attemptsTo(ConsultoEstadoCuentaGestionCuentasEPS.conLaCuentaDeLaIps( nroCuenta));
	}
	
	

	@And("^La cuenta se encuentra en estado$")
	public void laCuentaSeEncuentraEnEstado(List<String> cuentaEstado) {
		String cuenta = cuentaEstado.get(2);
		String estado = cuentaEstado.get(3);
		theActorInTheSpotlight().should(seeThat(ValidoEstadoCuenta.en(estado, cuenta)));
		theActorInTheSpotlight().attemptsTo(Esperar.por(2000));
	}
	
	
	
	@And("^se valida el estado de la cuenta en gestion de cuentas EPS$")
	public void seValidaElEstadoDeLaCuentaEnGestionDeCuentasEPS(List<String> cuentaEstado) {
		String cuenta = cuentaEstado.get(2);
		String estado = cuentaEstado.get(3);
		theActorInTheSpotlight().should(seeThat(ValidoEstadoCuentaEnGestionCtasEPS.en(estado, cuenta)));
		theActorInTheSpotlight().attemptsTo(Esperar.por(2000));
	}
	
	@And("^envio al proceso de homologacion$")
	public void envioAlProcesoDeHomologacion() {
		theActorInTheSpotlight().attemptsTo(EnviarAHomologar.cuenta());
	}

	
	
	
	
	
	
	

	@And("^Gestiono la encuenta, (.+)$")
	public void gestionoLaCuenta(String accionSobreLaCuenta) {
		theActorInTheSpotlight().attemptsTo(GestionoLaCuenta.realizandoLaAccion(accionSobreLaCuenta));
	}

	// EPS
	@And("^Consulto como Eps el estado de la cuenta$")
	public void consultoComoEpsElEstadoDela(List<String> cuenta) {
		String cuentaConsulta = cuenta.get(1);
		theActorInTheSpotlight().attemptsTo(ConsultoEstadoCuentaComoEps.conLaCuenta(cuentaConsulta));
	}

	@And("^Gestiono la encuenta como Eps, (.+)$")
	public void gestionoLaCuentaComoEps(String accionSobreLaCuenta) {
		theActorInTheSpotlight().attemptsTo(GestionoLaCuentaComoEps.realizandoLaAccion(accionSobreLaCuenta));
	}

	@And("^Marco la cuenta con todas las Facturas como Revisado$")
	public void MarcoLaCuentaConFacturasComoRevisado() {
		theActorInTheSpotlight().attemptsTo(marcoLaCuenta.comoRevisada());
	}

	@And("^Radico la cuenta con la Eps$")
	public void radicoLaCuentaConLaEps(List<String> radicar) {
		String regional = radicar.get(4);
		String claseDeServicio = radicar.get(5);
		String responsableDePago = radicar.get(6);
		String observaciones = radicar.get(7);
		
		theActorInTheSpotlight().attemptsTo(EpsRadicaCuenta.conLosDatos(regional, claseDeServicio, responsableDePago,observaciones));
	}

	@Then("^La cuenta se encuentra por la Eps en estado$")
	public void laCuentaSeEncuentraPorLaEnEstado(List<String> cuentaEstado) {
		String cuenta = cuentaEstado.get(2);
		String estado = cuentaEstado.get(3);
		theActorInTheSpotlight().should(seeThat(ValidoEstadoCuentaEps.en(estado, cuenta)));
		theActorInTheSpotlight().attemptsTo(Esperar.por(2000));
	}

}
