package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class MenuPage {

	public static final Target MENU_PRINCIPAL = Target.the("{0}").locatedBy("//span[contains(text(),'{0}')]/ancestor-or-self::a");
	public static final Target MENU_SECUNDARIO = Target.the("{0}")
			.locatedBy("//li[contains(@class,'open')]/ul/li/a/span[contains(text(),'{0}')]");
	public static final Target DESPLEGAR_MENU = Target.the("Desplegar Menu").locatedBy("//div[@class='menu page-sidebar sidebar-fixed']");

}
