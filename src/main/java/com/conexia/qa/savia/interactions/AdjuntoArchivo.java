package com.conexia.qa.savia.interactions;

import static com.conexia.qa.savia.user_interfaces.CommonPage.ADJUNTAR_ARCHIVO;

import org.openqa.selenium.WebElement;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class AdjuntoArchivo implements Interaction{

	private String ruta;
	private Target alCampo;
	
	
	public AdjuntoArchivo(String ruta, Target alCampo) {
		this.ruta = ruta;
		if(alCampo!=null) {
			this.alCampo = alCampo;
		}
		else {
			this.alCampo = ADJUNTAR_ARCHIVO;
		}
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		WebElement ElementoWeb = this.alCampo.resolveFor(actor);
		ElementoWeb.sendKeys(ruta);
		actor.attemptsTo(EsperarCargando.pagina(),EsperarCargandoArchivo.enElFormulario());
	}
	
	public static AdjuntoArchivo con(String ruta, Target alCampo) {
		return Tasks.instrumented(AdjuntoArchivo.class, ruta, alCampo);
		
	}

}
