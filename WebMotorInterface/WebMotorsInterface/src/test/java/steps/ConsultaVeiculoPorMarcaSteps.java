package steps;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import Entidades.Veiculo;
import java.util.concurrent.*;


public class ConsultaVeiculoPorMarcaSteps {
	
	String url;
	private final WebDriver driver = new FirefoxDriver();
	//private final WebDriver driver = new ChromeDriver();
	
	Veiculo veiculo = new Veiculo();		
		
	
	@Dado("^A URL do site para acesso \"([^\"]*)\"$")
	public void acessarSiteConsultaMarca(String p_url)throws Throwable {	
		driver.get(p_url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			
	}
	
	@Quando("^Insiro a marca \"([^\"]*)\" do veiculo no campo de pesquisa$")
	public void informarMarcaVeiculo(String p_marca) throws Throwable {				
		veiculo.setMarca(p_marca);
		Thread.sleep(2000);
		driver.findElement(By.id("searchBar")).sendKeys(veiculo.getMarca());			
	}
	
	
	@Entao("^Devo poder escolher o modelo \"([^\"]*)\" do veiculo$")
	public void escolherModelo(String p_modelo) throws Throwable {		
		veiculo.setModelo(p_modelo);			
		Thread.sleep(2000);		
		driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[2]/div[1]/div[2]/div/div/div/div/div/div[2]/a[3]")).click();
	}
	
	@Entao("^O sistema deve apresentar a lista de veiculos conforme marca e modelo$")
	public void validarPesquisa() throws Throwable {
			
		Thread.sleep(2000);
		
		//Valida Marca		
		String marca = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/div[2]/div[1]")).getText();
		Assert.assertEquals(veiculo.getMarca(), marca);

		//Valida Modelo
		String modelo = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/div[2]/div[2]")).getText();
		Assert.assertEquals(veiculo.getModelo(), modelo);					
	}
		

	@After
	public void fechaBrowser2() {
		driver.quit();
	}
		


}
