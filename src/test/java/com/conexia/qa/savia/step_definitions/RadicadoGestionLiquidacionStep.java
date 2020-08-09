package com.conexia.qa.savia.step_definitions;

import static com.conexia.qa.savia.models.FiltrosBusqueda.guardarInformacion;
import static com.conexia.qa.savia.models.FiltrosBusqueda.traerInformacion;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.List;

import com.conexia.qa.savia.models.FiltrosBusqueda;
import com.conexia.qa.savia.models.InformacionComplementariaFactura;
import com.conexia.qa.savia.questions.ValidoEstadoRadicado;
import com.conexia.qa.savia.questions.verEnAsignacionActual;
import com.conexia.qa.savia.tasks.AsignoEnBandejaRadicados;
import com.conexia.qa.savia.tasks.BuscarRadicado;
import com.conexia.qa.savia.tasks.CierreYConfirmarCierreCuenta;
import com.conexia.qa.savia.tasks.DiligenciaOpcionesDeFactura;
import com.conexia.qa.savia.tasks.FacturasRadicadasMarco;
import com.conexia.qa.savia.tasks.ListasDeTrabajo;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class RadicadoGestionLiquidacionStep {

	@And("^Consulto radicado en listas de trabajo$")
	public void consultoRadicadoEnListasDeTrabajo(List<FiltrosBusqueda> filtrarPor) {
		FiltrosBusqueda.limpiarInformacion();
		guardarInformacion(filtrarPor);
		int indice = 0;
		while (indice < filtrarPor.size()) {
			theActorInTheSpotlight().attemptsTo(BuscarRadicado.porFiltros(traerInformacion(indice).getFiltrarPor(),
					traerInformacion(indice).getValorBusqueda()));
			indice = indice + 1;
		}
	}

	@And("^Realizo la accion (.+) en listas de trabajo$")
	public void realizoLaAccionVerDetalleEnListasDeTrabajo(String accionEnListraTrabajo) {
		theActorInTheSpotlight().attemptsTo(ListasDeTrabajo.realizoAccion(accionEnListraTrabajo));
	}

	@And("^Marco todas las facturas como revisadas$")
	public void marcoTodasLasFacturasComoRevisadas() {
		theActorInTheSpotlight().attemptsTo(FacturasRadicadasMarco.todasLasFacturas(true));
	}

	@And("^Diligenciar Opciones de Factura Informacion complementaria$")
	public void diliencioOpcionesDeFacturaInfoComplement(
			List<InformacionComplementariaFactura> InformacionValidarRipsData) {
		theActorInTheSpotlight().attemptsTo(DiligenciaOpcionesDeFactura.enInformacionComplementaria(
				InformacionValidarRipsData.get(0).getCodDiagnostico(), InformacionValidarRipsData.get(0).getAplicaPBS(),
				InformacionValidarRipsData.get(0).getCentroDeCosto(), InformacionValidarRipsData.get(0).getAltoCosto(),
				InformacionValidarRipsData.get(0).getAplicaNOPBS()));
	}

	@Then("^Radicado en estado (.+) en listas de trabajo radicado$")
	public void radicadoEnEstadoEnListasDeTrabajo(String estado) {
		theActorInTheSpotlight().should(seeThat(ValidoEstadoRadicado.enListaDeTrabajo(estado)));
	}

	@And("^Asigno a (.+), de la Regional: (.+), con el cargo:(.+)$")
	public void asignoA(String nombre, String regional, String cargo) {
		theActorInTheSpotlight().attemptsTo(AsignoEnBandejaRadicados.alUsuarioConLosDatos(regional,cargo, nombre));
	}
	
	@Then ("^Puedo ver a (.+), en asignación actual$")
	public void puedoVerAUsuarioEnAsignaciónActual(String usuario) {
		theActorInTheSpotlight().should(seeThat(verEnAsignacionActual.alUsuario(usuario)));
	}
	
	@And("^Cierro la cuenta y confirmo cierre de cuenta$")
	public void cierroLaCuentaYConfirmoCierreDeCuenta() {
		theActorInTheSpotlight().attemptsTo(CierreYConfirmarCierreCuenta.enBandejaRadicado());
	}

}
