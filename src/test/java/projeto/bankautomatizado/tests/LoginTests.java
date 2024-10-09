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
		home.login("000.000.000-00", "Teste525@", "Usuário ou senha incorretos");
	}

	@Test
	public void loginEmailInvalido() {
		home.login("teste@teste.com.br", "Teste525@", "Usuário ou senha incorretos");
	}

	@Test
	public void loginComSenhaInvalida() {
		home.login("526.128.275-94", "125888", "Usuário ou senha incorretos");
	}

	@Test
	public void loginComDadosEmBranco() {
		home.login("", "", "Usuário ou senha incorretos");
	}

	@Test
	public void loginComClienteNaoCadastrado() {
		home.login("123.315.528-29", "Teste525@", "Usuário ou senha incorretos");
	}

}
