package Entidades;

public class Veiculo {
	
	private String modelo;
	private String marca;
	private String versao;
	
	
	public Veiculo() {
		super();
		this.modelo = "";
		this.marca = "";
		this.versao = "";
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	
	
	

}
