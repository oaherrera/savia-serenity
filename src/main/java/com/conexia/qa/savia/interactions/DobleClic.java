package com.conexia.qa.savia.interactions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.conexia.qa.savia.drivers.OwnWebDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class DobleClic implements Interaction{

	private Target Elemento;
	
	
	
	public DobleClic(Target elemento) {
		Elemento = elemento;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		WebElement ElementoWeb = this.Elemento.resolveFor(actor);
		Actions Accion = new Actions(OwnWebDriver.getDriver());
		Accion.moveToElement(ElementoWeb).doubleClick().build().perform();
	}
	
	public static DobleClic En (Target Elemento) {
		return Tasks.instrumented(DobleClic.class, Elemento);

		
	}

	
	
}

