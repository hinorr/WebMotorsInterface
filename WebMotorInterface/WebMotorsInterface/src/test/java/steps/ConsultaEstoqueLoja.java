package steps;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import Entidades.Loja;
import Entidades.Veiculo;
import java.util.concurrent.*;


public class ConsultaEstoqueLoja {
	
	String url;
	private final WebDriver driver = new FirefoxDriver();
	//private final WebDriver driver = new ChromeDriver();	
	
	Veiculo veiculo = new Veiculo();		
	Loja loja = new Loja();
			
	@Dado("^A URL doo site paraa acesso \"([^\"]*)\"$")
	public void acessarSiteConsultaMarca(String p_url)throws Throwable {	
		driver.get(p_url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			
	}
			
	
	@Quando("^Insiro a marca \"([^\"]*)\" do veicculo no campo de pesquisa$")
	public void informarMarcaVeiculo(String p_marca) throws Throwable {				
		veiculo.setMarca(p_marca);
		Thread.sleep(2000);
		driver.findElement(By.id("searchBar")).sendKeys(veiculo.getMarca());		
	}	
	
	
	@Quando("^Escolher o modelo \"([^\"]*)\" do veiculo$")
	public void escolherModelo(String p_modelo) throws Throwable {		
		veiculo.setModelo(p_modelo);			
		Thread.sleep(2000);				
		driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[2]/div[1]/div[2]/div/div/div/div/div/div[2]/a[3]")).click();
	}
	
	@Quando("^Escolho o primeiro veiculo da lista de pesquisa$")
	public void escolherPrimeiroVeiculo() throws Throwable {					
		Thread.sleep(2000);		
		driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[3]/div[2]/div/div/div/div[1]/div/div[1]/div/div[1]/a[1]/img")).click();
	}
	
	@Quando("^Escolho a opcao ver todos os carros deste vendedor$")
	public void selecionarListaVeiculosClientes() throws Throwable {						
		Thread.sleep(2000);														
		String nomeLoja = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/div/div[3]/div/div[4]/div[2]/div[1]/div[1]/h2")).getText();
		loja.setNome(nomeLoja);		
		driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[3]/div[2]/div/div/div/div[1]/div/div[1]/div/div[1]/a[2]")).click();
	}
		
	
	@Entao("^O sistema deve apresentar a lista de veiculos da loja selecionada$")
	public void validarPesquisa() throws Throwable {			
		Thread.sleep(2000);
		//Valida loja							     
		String nomeLoja = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[1]/div/div[2]/div/ul/li[1]/a")).getText();
		Assert.assertEquals(loja.getNome(), nomeLoja);						
	}
				

	@After
	public void fechaBrowser2() {
		driver.quit();
	}
		


}
