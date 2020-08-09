package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.RadicadoFacturasRadicadasPage.MARCAR_TODOS;
import static com.conexia.qa.savia.user_interfaces.RadicadoFacturasRadicadasPage.TABLA_ENCABEZADO;
import static com.conexia.qa.savia.user_interfaces.CommonPage.BUARDAR;
import static com.conexia.qa.savia.user_interfaces.CommonPage.BUSCAR;
import static com.conexia.qa.savia.user_interfaces.CommonPage.CONFIRMAR_ACEPTAR;
import static com.conexia.qa.savia.user_interfaces.CommonPage.VOLVER;
import static com.conexia.qa.savia.user_interfaces.FacturaInformacionComplementariaPage.ALTO_COSTO;
import static com.conexia.qa.savia.user_interfaces.FacturaInformacionComplementariaPage.APLICA_NOPBS;
import static com.conexia.qa.savia.user_interfaces.FacturaInformacionComplementariaPage.APLICA_PBS;
import static com.conexia.qa.savia.user_interfaces.FacturaInformacionComplementariaPage.BUSCAR_CENTRO_DE_COSTO;
import static com.conexia.qa.savia.user_interfaces.FacturaInformacionComplementariaPage.BUSCAR_DIAGNOSTICO;
import static com.conexia.qa.savia.user_interfaces.FacturaInformacionComplementariaPage.CENTRO_DE_COSTO;
import static com.conexia.qa.savia.user_interfaces.FacturaInformacionComplementariaPage.CODIGO_DIAGNOSTICO;
import static com.conexia.qa.savia.user_interfaces.FacturaInformacionComplementariaPage.INFORMACION_COMPLEMNENTARIA;
import static com.conexia.qa.savia.user_interfaces.FacturaInformacionComplementariaPage.REGISTRO_SELECCION;

import com.conexia.qa.savia.interactions.AtributosElemento;
import com.conexia.qa.savia.interactions.Esperar;
import com.conexia.qa.savia.interactions.EsperarCargando;
import com.conexia.qa.savia.interactions.MueveScroll;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class DiligenciaOpcionesDeFactura implements Task {

	private String codDiagnostico;
	private String aplicaPBS;
	private String centroDeCosto;
	private String altoCosto;
	private String aplicaNOPBS;

	public DiligenciaOpcionesDeFactura(String codDiagnostico, String aplicaPBS, String centroDeCosto, String altoCosto,
			String aplicaNOPBS) {
		this.codDiagnostico = codDiagnostico;
		this.aplicaPBS = aplicaPBS;
		this.centroDeCosto = centroDeCosto;
		this.altoCosto = altoCosto;
		this.aplicaNOPBS = aplicaNOPBS;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(INFORMACION_COMPLEMNENTARIA));
		actor.attemptsTo(AtributosElemento.setiarAtributo(TABLA_ENCABEZADO, "style", "margin-right: 15px; margin-left: -2000px;"));
		actor.attemptsTo(Click.on(MARCAR_TODOS));
		actor.attemptsTo(MueveScroll.vertical(400));
		actor.attemptsTo(Click.on(BUSCAR_DIAGNOSTICO));
		actor.attemptsTo(Enter.theValue(codDiagnostico).into(CODIGO_DIAGNOSTICO));
		actor.attemptsTo(Click.on(BUSCAR));
		actor.attemptsTo(Click.on(REGISTRO_SELECCION.of(codDiagnostico)));
		actor.attemptsTo(Click.on(APLICA_PBS.of(aplicaPBS)));
		if(aplicaPBS.equals("Si")) {		
			actor.attemptsTo(Click.on(BUSCAR_CENTRO_DE_COSTO),Esperar.por(1000));
			actor.attemptsTo(Enter.theValue(centroDeCosto).into(CENTRO_DE_COSTO),Esperar.por(1000));
			actor.attemptsTo(Click.on(BUSCAR),Esperar.por(1000));
			actor.attemptsTo(Click.on(REGISTRO_SELECCION.of(centroDeCosto)),Esperar.por(1000));
		}
		actor.attemptsTo(Click.on(ALTO_COSTO.of(altoCosto)));
		actor.attemptsTo(Click.on(APLICA_NOPBS.of(aplicaNOPBS)));
		actor.attemptsTo(Click.on(BUARDAR));
		actor.attemptsTo(Click.on(CONFIRMAR_ACEPTAR),EsperarCargando.pagina(),Esperar.por(1000));
		actor.attemptsTo(Click.on(VOLVER),EsperarCargando.pagina());
		
	}

	public static DiligenciaOpcionesDeFactura enInformacionComplementaria(String codDiagnostico, String aplicaPBS,
			String centroDeCosto, String altoCosto, String aplicaNOPBS) {

		return Tasks.instrumented(DiligenciaOpcionesDeFactura.class, codDiagnostico, aplicaPBS, centroDeCosto,
				altoCosto, aplicaNOPBS);
	}

}
