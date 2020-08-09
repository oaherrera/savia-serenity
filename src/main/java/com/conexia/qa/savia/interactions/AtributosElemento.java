package com.conexia.qa.savia.interactions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.conexia.qa.savia.drivers.OwnWebDriver;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class AtributosElemento implements Interaction{

	private Target elemento;
	private String atributo;
	private String valor;
	
	
	
	public AtributosElemento(Target elemento, String atributo, String valor) {
		this.elemento = elemento;
		this.atributo = atributo;
		this.valor = valor;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		WebElement element = elemento.resolveFor(actor);
		
			JavascriptExecutor js = (JavascriptExecutor) OwnWebDriver.getDriver();
			js.executeScript("arguments[0].removeAttribute('" + atributo + "')", element);
			js.executeScript("arguments[0].setAttribute('" + atributo + "', '" + valor+ "')", element);
			
	}
	
	public static AtributosElemento setiarAtributo(Target elemento, String atributo, String valor) {
		return Tasks.instrumented(AtributosElemento.class, elemento, atributo, valor);
	}

}
