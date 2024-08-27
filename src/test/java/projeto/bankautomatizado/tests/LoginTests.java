package projeto.bankautomatizado.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projeto.bankautomatizado.pages.HomePage;
import projeto.bankautomatizado.runner.Executa;

public class LoginTests {

	HomePage home = new HomePage();

	@BeforeEach
	public void antesDoTeste() {
		Executa.abrirNavegador();

	}

	@AfterEach
	public void depoisDoTeste() {
		Executa.fecharNavegador();
	}

	@Test
	public void loginComSucessoComCpf() {
		home.login("526.128.275-94", "Teste525@");
	}

	@Test
	public void loginComSucessoComEmail() {
		home.login("@e2etreinamentos.com.br", "Teste525@");
	}

	@Test
	public void loginComCpfInvalido() {
		home.login("", "", "Usuário ou senha incorretos");
	}

	@Test
	public void loginEmailInvalido() {
		home.login("", "", "Usuário ou senha incorretos");
	}

	@Test
	public void loginComSenhaInvalida() {
		home.login("", "", "Usuário ou senha incorretos");
	}

	@Test
	public void loginComDadosEmBranco() {
		home.login("", "", "Usuário ou senha incorretos");
	}

	@Test
	public void loginComClienteNaoCadastrado() {
		home.login("", "", "Usuário ou senha incorretos");
	}

	@Test
	public void loginUsuarioESenhaEmBranco() {
		home.login("", "", "Usuário ou senha incorretos");
	}

}
