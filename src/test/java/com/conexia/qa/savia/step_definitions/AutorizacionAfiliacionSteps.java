package com.conexia.qa.savia.step_definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.conexia.qa.savia.drivers.OwnWebDriver;
import com.conexia.qa.savia.interactions.AbrirOpcion;
import com.conexia.qa.savia.models.Selenium;
import com.conexia.qa.savia.questions.CreoAnexo3;
import com.conexia.qa.savia.tasks.AdjuntoSoportesFisicos;
import com.conexia.qa.savia.tasks.AgregaInsumo;
import com.conexia.qa.savia.tasks.AgregaMedicamento;
import com.conexia.qa.savia.tasks.AgregaProcedimiento;
import com.conexia.qa.savia.tasks.BuscaDiagnostico;
import com.conexia.qa.savia.tasks.BuscarAfiliado;
import com.conexia.qa.savia.tasks.BuscarProfesional;
import com.conexia.qa.savia.tasks.BuscarSedeIPS;
import com.conexia.qa.savia.tasks.DiligenciaTipoDeSolicitud;
import com.conexia.qa.savia.tasks.DiligenciarDatosAcompañanate;
import com.conexia.qa.savia.tasks.DiligenciarDatosSolicitud;
import com.conexia.qa.savia.tasks.DiligenciarServiciosSolicitados;
import com.conexia.qa.savia.tasks.IngresaJustificacionClinica;
import com.conexia.qa.savia.tasks.IngresarHistoriaClinica;
import com.conexia.qa.savia.tasks.Loguearse;
import com.conexia.qa.savia.tasks.ValidoSolicitud;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;

public class AutorizacionAfiliacionSteps {

	@Given("^me autentico con (.+) y contraseña (.+)$")
	public void meAutenticoConUsuarioYContraseña(String usuario, String contrasena) {
		setTheStage(Cast.ofStandardActors());
		theActorCalled(usuario); 
		theActorInTheSpotlight().can(BrowseTheWeb.with(OwnWebDriver.withChrome().setURL(Selenium.parameters().getProperty("url"))));
		theActorInTheSpotlight().attemptsTo(Loguearse.enElPortal(usuario, contrasena));
	}

	@Given("^Consulto afiliado con (.+) Nro (.+) en Autorizaciones$")
	public void consultoAfiliadoConTipoDocumentoNro(String tipoDocumento, String numeroDocumento) {
		theActorInTheSpotlight().attemptsTo(AbrirOpcion.delMenu("Solicitud autorización", "Solicitud"));
		theActorInTheSpotlight().attemptsTo(BuscarAfiliado.porTipoidentificacion(tipoDocumento, numeroDocumento));
	}

	@When("^Diligencio el formulario de autorizaciones con los datos (.+),(.+)$")
	public void diligencioElFormularioDeAutorizacionesConLosDatos(String Programa, String Servicio) {
		theActorInTheSpotlight().attemptsTo(DiligenciarDatosAcompañanate.enElFormulario("Christian", "0312878874", "3118337810"));
		theActorInTheSpotlight().attemptsTo(DiligenciaTipoDeSolicitud.enElFormulario(Programa, Servicio));
		theActorInTheSpotlight().attemptsTo(DiligenciarDatosSolicitud.enElFomularioSolicitud("1234"));
	}
	
	@And("^Asocio la sede con razon social (.+)$")
	public void asocioLaSedeCon(String nombreRazonSocial ) {
		theActorInTheSpotlight().attemptsTo(BuscarSedeIPS.porRazonSocial(nombreRazonSocial));
	}
	
	@And("^Asigno el profesional identifacado con (.+), (.+)$")
	public void asignoElProfesionalIdentificadoCon(String tipoDocumento,String documento) {
		theActorInTheSpotlight().attemptsTo(BuscarProfesional.porTipoDocumento(tipoDocumento, documento));
		theActorInTheSpotlight().attemptsTo(DiligenciarServiciosSolicitados.enElFormulario("Enfermedad general", "Prioritario","Servicios electivos", "Consulta externa"));
	}
	
	@And("^Asocio Diagnostico con el codigo (.+)$")
	public void asocioDiagnostricoConElCodigo (String codigoDiagnostico) {
		theActorInTheSpotlight().attemptsTo(BuscaDiagnostico.porCodigoDescripcion(codigoDiagnostico,"Confirmado"));
	}
	
	@And("^Agrego procedimiento con el id (.+) (.+)$")
	public void agregoProcedimientoConElId(String idDiagnostico, String descripcion){
		theActorInTheSpotlight().attemptsTo(AgregaProcedimiento.tipoPBS(idDiagnostico,"1", "Indicaciones"));
	}
	
	@And("^Agrego medicamento con el id (.+):(.+), del Diagnostico (.+)$")
	public void agregoMedicamentoConElId(String idMedimanco, String DescripcionMedicamento,String idDiagnostico){
		theActorInTheSpotlight().attemptsTo(AgregaMedicamento.tipoPBS(idMedimanco+":"+DescripcionMedicamento, idDiagnostico, "Accidente de trabajo", "Detección temprana de  Enfermedad general", "Cáncer", "1", "2", "Año", "Intramuscular", "1", "Descripcion de pruebas posologia."));
	}
	
	@And("^Agrego insumo con el id (.+) - (.+), del Diagnostico (.+)$")
	public void agregoInsumoConElId(String idMedimanco, String DescripcionMedicamento,String idDiagnostico){
		theActorInTheSpotlight().attemptsTo(AgregaInsumo.tipoPBS(idMedimanco+" - "+DescripcionMedicamento, idDiagnostico,"1"));
	}
	
	@And("Diligencio campos complementarios de la autorizacion")
	public void diligencioCamposComplementariosDeLaSolicitud() {
		theActorInTheSpotlight().attemptsTo(IngresaJustificacionClinica.conElValor("Justificación clinica Pruebas"));
		theActorInTheSpotlight().attemptsTo(IngresarHistoriaClinica.con("Evaluación Pruebas"));
	}
	
	@And("^Ajunto soporte fisico formato PDF ubicado en la ruta (.+) de Tipo (.+)$")
	public void adjuntoSoporteFisicoFormatoPDFUbicado(String ruta, String deTipo){
		theActorInTheSpotlight().attemptsTo(AdjuntoSoportesFisicos.enLaSolicitud(ruta, deTipo));
	}
	
	@And("Envio la solicitud a Validar")
	public void envioSolicitudAValidar() {
		theActorInTheSpotlight().attemptsTo(ValidoSolicitud.enviandola());
	}
	
	@Then("^Se debe generar una solicitud de afiliacion anexo4$")
	public void seDebeGenerarUnaSolicitudDeAfiliacionAnexo4() {
		theActorInTheSpotlight().should(seeThat(CreoAnexo3.Correctamente()));
	}
}
