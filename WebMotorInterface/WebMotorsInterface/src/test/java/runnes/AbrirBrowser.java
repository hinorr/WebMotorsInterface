package runnes;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/AbrirBrowser.feature", tags = "@abrirNabegador", glue = "steps")

public class AbrirBrowser {
	
	

}

