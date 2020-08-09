package com.conexia.qa.savia.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/Negociacion/Negociacion.feature", 
		snippets = SnippetType.CAMELCASE,
//		monochrome = true,
		glue = "com.conexia.qa.savia.step_definitions"
		,tags = "@AsignoAreaDeCobertura"
		//, tags = "@GestionarCuentaEnviarHomologar,@GestionarCuentaFinalizarHomologacion,@GestionarCuentaEnviarAVerificarEPS,@RevisarFacturasCuentaEps,@RegostroCuentaEps "
)

public class NegociacionRunner {

	
	
}
