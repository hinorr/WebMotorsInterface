#language: pt

@consultaEstoqueLoja
Funcionalidade: Consultar veiculo


	Cenario: 04 Consultar estoque de veiculos por loja
		Dado A URL doo site paraa acesso "https://www.webmotors.com.br"
		Quando Insiro a marca "HONDA" do veicculo no campo de pesquisa
		Quando Escolher o modelo "CITY" do veiculo
		Quando Escolho o primeiro veiculo da lista de pesquisa
		Quando Escolho a opcao ver todos os carros deste vendedor
		Entao O sistema deve apresentar a lista de veiculos da loja selecionada