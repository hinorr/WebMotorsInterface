#language: pt


@abrirNabegador
Funcionalidade: Acessar a Pagina WebMotors

	Cenario: 00 Acessar o navegado Webmotors
		Dado AA URL do site para acesso "https://www.webmotors.com.br"
		Quando Insiro a URL no campo de endereço do Navegador
		Entao Devo ver a seguinte pagina "https://www.webmotors.com.br"
