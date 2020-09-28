package runnes;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/ConsultaEstoqueLoja.feature", tags = "@consultaEstoqueLoja", glue = "steps")

public class ConsultaEstoqueLoja {
	
	

}

