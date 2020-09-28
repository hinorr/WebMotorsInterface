package steps;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import Entidades.Veiculo;


public class ConsultaVersaoDeVeiculoPorModeloSteps {
		
	private final WebDriver driver = new FirefoxDriver();
	//private final WebDriver driver = new ChromeDriver();
	
	Veiculo veiculo = new Veiculo();
	
	
	@Dado("^A URL doo site para acesso \"([^\"]*)\"$")
	public void acessarSite(String p_url)throws Throwable {	
		driver.get(p_url);		
	}
			
	@Quando("^Insiro o modelo \"([^\"]*)\" do veiculoo no campo de pesquisa$")
	public void informarModeloVeiculo(String p_modelo) throws Throwable {				
		veiculo.setModelo(p_modelo);			
		Thread.sleep(3000);			
		driver.findElement(By.id("searchBar")).sendKeys(veiculo.getModelo());			
	}
		
	
	@Quando("^Escolho a mmarca \"([^\"]*)\" do veiculo$")
	public void escolherMarca(String p_marca) throws Throwable {																		
		veiculo.setMarca(p_marca);					
		Thread.sleep(2000);	
		driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[2]/div[1]/div[2]/div/div/div/div/div/div/a")).click();		
	}
	
	@Entao("^Devo poderr escolher a versao \"([^\"]*)\" do veiculo$")
	public void escolherVersao(String p_versao) throws Throwable {																	
		veiculo.setVersao(p_versao);					
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/div[2]/div[3]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div[2]/div/div[4]/a[1]")).click();
				
	}
				
	
	@Entao("^O sistemaa deve apresentar a lista de veiculos conforme marca, modelo e versao$")
	public void validarPesquisa() throws Throwable {
			
		Thread.sleep(2000);
		
		//Valida Marca		
		String marca = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/div[2]/div[1]")).getText();
		Assert.assertEquals(veiculo.getMarca(), marca);
		
		//Valida Modelo
		String modelo = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/div[2]/div[2]")).getText();
		Assert.assertEquals(veiculo.getModelo(), modelo);
			
		//Validar Versao		
		String versao = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/div[2]/div[3]")).getText();
		Assert.assertEquals(veiculo.getVersao(), versao);
		//Assert.assertEquals(veiculo.getVersao(), "versao qualquer");
					
	}



}
