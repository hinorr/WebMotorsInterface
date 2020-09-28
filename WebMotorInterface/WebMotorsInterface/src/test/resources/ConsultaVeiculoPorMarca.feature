#language: pt


@consultaMarca
Funcionalidade: Consultar o veiculo 
		
	Cenario: 01 Consultar veiculo por marca
		Dado A URL do site para acesso "https://www.webmotors.com.br"
		Quando Insiro a marca "HONDA" do veiculo no campo de pesquisa
		Entao Devo poder escolher o modelo "CITY" do veiculo
		Entao O sistema deve apresentar a lista de veiculos conforme marca e modelo
