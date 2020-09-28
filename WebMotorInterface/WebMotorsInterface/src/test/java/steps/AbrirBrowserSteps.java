package steps;


import org.junit.Assert;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import Entidades.Veiculo;


public class AbrirBrowserSteps {
	
	String url;
	private final WebDriver driver = new FirefoxDriver();
	//private final WebDriver driver = new ChromeDriver();
	
	Veiculo veiculo = new Veiculo();
			
	
	@Dado("^AA URL do site para acesso \"([^\"]*)\"$")
		public void acessarSite(String p_url)throws Throwable {
			driver.get(p_url);		
	}
	
	@Quando("^Insiro a URL no campo de endereço do Navegador$")
	public void informo_o_site() throws Throwable {	
		
	}
	
	@Entao("^Devo ver a seguinte pagina \"([^\"]*)\"$")
	public void vejo_a_mensagem(String p_url) throws Throwable {		
		Assert.assertEquals(p_url, driver.getCurrentUrl().substring(0, 28));		
	}
	
	@After
	public void fechaBrowser() {
		driver.quit();
	}

}