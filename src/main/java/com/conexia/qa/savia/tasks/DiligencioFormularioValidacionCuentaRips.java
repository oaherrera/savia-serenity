package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.models.InformacionValidarRips.traerInformacion;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.ANHO_DE_PRESTACION;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.ANHO_DE_PRESTACION_SELECCION;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.BUSCAR_CONTRATO;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.IPS;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.IPS_SELECCION;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.LUPA_BUSCAR_CONTRATO;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.MES_DE_PRESTACION;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.MES_DE_PRESTACION_SELECCION;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.NUMERO_DE_CUENTA;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.REGIONAL;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.REGIONAL_SELECCION;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.RESPONSABE_DE_PAGO;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.RESPONSABE_DE_PAGO_SELECCION;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.SELECCIONAR;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.TIPO_DE_SERVICIO;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.TIPO_DE_SERVICIO_SELECCION;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.VALOR_CUENTA;
import com.conexia.qa.savia.interactions.Esperar;
import com.conexia.qa.savia.interactions.EsperarCargando;
import com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class DiligencioFormularioValidacionCuentaRips implements Task {

	private String ips;
	private String mesPrestacion;
	private String anhoPrestacion;
	private String nroCuenta;
	private String valorCuenta;
	private String contrato;
	private String responsableDePago;
	private String regional;
	private String tipoDeServicio;

	public DiligencioFormularioValidacionCuentaRips() {
		this.ips = traerInformacion(0).getIps();
		this.mesPrestacion = traerInformacion(0).getMesPrestacion();
		this.anhoPrestacion = traerInformacion(0).getAnhoPrestacion();
		this.nroCuenta = traerInformacion(0).getNroCuenta();
		this.valorCuenta = traerInformacion(0).getValorCuenta();
		this.contrato = traerInformacion(0).getControto();
		this.responsableDePago = traerInformacion(0).getResponsableDePago();
		this.regional = traerInformacion(0).getRegional();
		this.tipoDeServicio = traerInformacion(0).getTipoDeServicio();
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		Serenity.takeScreenshot();
		actor.attemptsTo(Enter.theValue(ips).into(IPS));
		actor.attemptsTo(Click.on(IPS_SELECCION.of(ips)), Esperar.por(1000));
		actor.attemptsTo(Click.on(MES_DE_PRESTACION));
		actor.attemptsTo(Click.on(MES_DE_PRESTACION_SELECCION.of(mesPrestacion)));
		actor.attemptsTo(Click.on(ANHO_DE_PRESTACION));
		actor.attemptsTo(Click.on(ANHO_DE_PRESTACION_SELECCION.of(anhoPrestacion)));
		actor.attemptsTo(Enter.theValue(nroCuenta).into(NUMERO_DE_CUENTA));
		actor.attemptsTo(Enter.theValue(valorCuenta).into(VALOR_CUENTA), EsperarCargando.pagina());
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(LUPA_BUSCAR_CONTRATO), Esperar.por(500));
		actor.attemptsTo(Enter.theValue(contrato).into(RipsValidacionCuentaPage.INPUT_NUMERO_CONTRATO),Esperar.por(500));
		actor.attemptsTo(Click.on(BUSCAR_CONTRATO), Esperar.por(300));
		actor.attemptsTo(Click.on(SELECCIONAR), Esperar.por(300));
		actor.attemptsTo(Click.on(REGIONAL));
		actor.attemptsTo(Click.on(REGIONAL_SELECCION.of(regional)), Esperar.por(300));
		actor.attemptsTo(Click.on(RESPONSABE_DE_PAGO), Esperar.por(300));
		actor.attemptsTo(Click.on(RESPONSABE_DE_PAGO_SELECCION.of(responsableDePago)), Esperar.por(300));
		actor.attemptsTo(Click.on(TIPO_DE_SERVICIO), Esperar.por(300));
		actor.attemptsTo(Click.on(TIPO_DE_SERVICIO_SELECCION.of(tipoDeServicio)),
				Esperar.por(300));

	}

	public static DiligencioFormularioValidacionCuentaRips conTodosLosDatos() {
		return Tasks.instrumented(DiligencioFormularioValidacionCuentaRips.class);
	}

}
