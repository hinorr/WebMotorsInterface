#language: pt


@consultaVersaoPorModelo
Funcionalidade: Consultar veiculo


	Cenario: 03 Consultar versao do veiculo por modelo
		Dado A URL doo site para acesso "https://www.webmotors.com.br"
		Quando Insiro o modelo "CITY" do veiculoo no campo de pesquisa
		Quando Escolho a mmarca "HONDA" do veiculo
		Entao Devo poderr escolher a versao "1.5 DX 16V FLEX 4P AUTOMÁTICO" do veiculo		
		Entao O sistemaa deve apresentar a lista de veiculos conforme marca, modelo e versao
	