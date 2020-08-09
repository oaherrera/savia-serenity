package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.LogueoIpsPage.BOTON_INGRESAR;
import static com.conexia.qa.savia.user_interfaces.LogueoIpsPage.BUSCAR_POR_RAZON_SOCIAL;
import static com.conexia.qa.savia.user_interfaces.LogueoIpsPage.VALIDAR_RIPS;
import com.conexia.qa.savia.user_interfaces.LogueoIpsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class RealizaElLogueo implements Task {
	
	private String ips;
	
	public RealizaElLogueo(String ips) {
		
		this.ips = ips;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(BUSCAR_POR_RAZON_SOCIAL));
		actor.attemptsTo(Enter.theValue(ips).into(LogueoIpsPage.INPUT_RAZON_SOCIAL));
		actor.attemptsTo(Click.on(LogueoIpsPage.RAZON_SOCIAL_SELECCION.of(ips)));
		actor.attemptsTo(Click.on(VALIDAR_RIPS));
		actor.attemptsTo(Click.on(BOTON_INGRESAR));
		
		
		
	}
	
	public static RealizaElLogueo deIps(String ips) {
		
		return Tasks.instrumented(RealizaElLogueo.class, ips );
	}
	
	

}
