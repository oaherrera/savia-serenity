package com.conexia.qa.savia.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class Esperar implements Interaction{

	private long milisegundos;
	
	
	public Esperar(long milisegundos) {
		this.milisegundos = milisegundos;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		try {
			
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Esperar por(long milisegundos) {
		return Tasks.instrumented(Esperar.class, milisegundos);
	}
	
	

}
