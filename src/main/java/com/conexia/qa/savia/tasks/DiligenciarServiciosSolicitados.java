package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.ServiciosSolicitadosPage.ORIGEN_DE_LA_ATENCION;
import static com.conexia.qa.savia.user_interfaces.ServiciosSolicitadosPage.ORIGEN_DE_LA_ATENCION_SELECCION;
import static com.conexia.qa.savia.user_interfaces.ServiciosSolicitadosPage.PRIORIDAD_DE_LA_aTENCION;
import static com.conexia.qa.savia.user_interfaces.ServiciosSolicitadosPage.PRIORIDAD_DE_LA_aTENCION_SELECCION;
import static com.conexia.qa.savia.user_interfaces.ServiciosSolicitadosPage.TIPO_SERVICIO_SOLICITADO;
import static com.conexia.qa.savia.user_interfaces.ServiciosSolicitadosPage.TIPO_SERVICIO_SOLICITADO_SELECCION;
import static com.conexia.qa.savia.user_interfaces.ServiciosSolicitadosPage.UBICACION_DEL_PACIENTE;
import static com.conexia.qa.savia.user_interfaces.ServiciosSolicitadosPage.UBICACION_DEL_PACIENTE_SELECCION;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.Esperar;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class DiligenciarServiciosSolicitados implements Task{

	private String origenDeLaAtencion;
	private String prioridadDeLaAntencion;
	private String tipoDeServicioSolicitado;
	private String ubicacionDelPaciente;
	
	
	public DiligenciarServiciosSolicitados(String origenDeLaAtencion, String prioridadDeLaAntencion,
			String tipoDeServicioSolicitado, String ubicacionDelPaciente) {
		this.origenDeLaAtencion = origenDeLaAtencion;
		this.prioridadDeLaAntencion = prioridadDeLaAntencion;
		this.tipoDeServicioSolicitado = tipoDeServicioSolicitado;
		this.ubicacionDelPaciente = ubicacionDelPaciente;
	}


	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Esperar.por(1200));
		takeScreenshot();
		actor.attemptsTo(Click.on(ORIGEN_DE_LA_ATENCION));
		actor.attemptsTo(Click.on(ORIGEN_DE_LA_ATENCION_SELECCION.of(origenDeLaAtencion)));
		actor.attemptsTo(Click.on(PRIORIDAD_DE_LA_aTENCION));
		actor.attemptsTo(Click.on(PRIORIDAD_DE_LA_aTENCION_SELECCION.of(prioridadDeLaAntencion)));
		actor.attemptsTo(Click.on(TIPO_SERVICIO_SOLICITADO));
		actor.attemptsTo(Click.on(TIPO_SERVICIO_SOLICITADO_SELECCION.of(tipoDeServicioSolicitado)),Esperar.por(3000));
		actor.attemptsTo(Click.on(UBICACION_DEL_PACIENTE),Esperar.por(3000));
		actor.attemptsTo(Click.on(UBICACION_DEL_PACIENTE_SELECCION.of(ubicacionDelPaciente)),Esperar.por(3000));
		takeScreenshot();
	}


	public static DiligenciarServiciosSolicitados enElFormulario(String origenDeLaAtencion, String prioridadDeLaAntencion,String tipoDeServicioSolicitado, String ubicacionDelPaciente) {
		return Tasks.instrumented(DiligenciarServiciosSolicitados.class, origenDeLaAtencion, prioridadDeLaAntencion,tipoDeServicioSolicitado, ubicacionDelPaciente);
	}
}
