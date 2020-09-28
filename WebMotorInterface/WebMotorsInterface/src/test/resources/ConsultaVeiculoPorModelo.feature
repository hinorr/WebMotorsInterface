#language: pt


@consultaModelo
Funcionalidade: Consultar o veiculo

	Cenario: 02 Consultar veiculo por modelo
		Dado A URLL do site para acesso "https://www.webmotors.com.br"
		Quando IInsiro o modelo "CITY" do veiculo no campo de pesquisa
		Entao Devo poder escolher a marca "HONDA" do veiculo
		Entao OO sistema deve apresentar a lista de veiculos conforme marca e modelo
