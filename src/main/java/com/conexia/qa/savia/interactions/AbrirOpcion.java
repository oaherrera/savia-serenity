package com.conexia.qa.savia.interactions;

import static com.conexia.qa.savia.interactions.AtributosElemento.setiarAtributo;
import static com.conexia.qa.savia.user_interfaces.MenuPage.DESPLEGAR_MENU;

import com.conexia.qa.savia.user_interfaces.MenuPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class AbrirOpcion implements Interaction {

	private String opcionPrincipal;
	private String opcionSecundaria;

	public AbrirOpcion(String opcionPrincipal, String opcionSecundaria) {
		this.opcionPrincipal = opcionPrincipal;
		this.opcionSecundaria = opcionSecundaria;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		Serenity.takeScreenshot();
		if (opcionPrincipal != null) {
			actor.attemptsTo(setiarAtributo(DESPLEGAR_MENU, "style", "display:block;"));
			actor.attemptsTo(Click.on(MenuPage.MENU_PRINCIPAL.of(opcionPrincipal)));
			actor.attemptsTo(Click.on(MenuPage.MENU_SECUNDARIO.of(opcionSecundaria)));
		} else {
			actor.attemptsTo(Click.on(MenuPage.MENU_SECUNDARIO.of(opcionSecundaria)));
		}
		Serenity.takeScreenshot();
	}

	public static AbrirOpcion delMenu(String opcionPrincipal, String opcionSecundaria) {
		return Tasks.instrumented(AbrirOpcion.class, opcionPrincipal, opcionSecundaria);
	}

	public static AbrirOpcion delMenuDesplegado(String opcionPrincipal, String opcionSecundaria) {
		return Tasks.instrumented(AbrirOpcion.class, null, opcionSecundaria);
	}

}
