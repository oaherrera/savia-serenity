package com.conexia.qa.savia.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/tester/RipsCapita.feature", 
		snippets = SnippetType.CAMELCASE,
//		monochrome = true,
		glue = "com.conexia.qa.savia.step_definitions"
		, tags = "@CargarRipsDeCapita"
		//, tags = "@GestionarCuentaEnviarAVerificarEPS,@RevisarFacturasCuentaEps,@RegostroCuentaEps "
)

public class RipsCapitaRunner {

}
