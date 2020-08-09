package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.LoginPage.CONTRASEÑA;
import static com.conexia.qa.savia.user_interfaces.LoginPage.INICIAR_SESION;
import static com.conexia.qa.savia.user_interfaces.LoginPage.NOMBRE_USUARIO;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Loguearse implements Task {

	private String usuario;
	private String contrasena;

	public Loguearse(String usuario, String contrasena) {
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		actor.attemptsTo(
				Enter.theValue(usuario).into(NOMBRE_USUARIO),
				Enter.theValue(contrasena).into(CONTRASEÑA)
						);
		takeScreenshot();
		actor.attemptsTo(Click.on(INICIAR_SESION));
		takeScreenshot();
	}

	public static Loguearse enElPortal(String usuario, String contrasena) {
		return Tasks.instrumented(Loguearse.class, usuario, contrasena);
	}
}
