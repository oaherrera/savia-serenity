package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

	private LoginPage() {
	}

	public static final Target NOMBRE_USUARIO = Target.the("Nombre de Usuario").locatedBy("//input[@id='username']");
	public static final Target CONTRASEÑA = Target.the("Contraseña").locatedBy("//input[@id='password']");
	public static final Target INICIAR_SESION = Target.the("Iniciar Sesión").locatedBy("//input[@name='submit']");
}
