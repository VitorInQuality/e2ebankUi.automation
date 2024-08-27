package projeto.bankautomatizado.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projeto.bankautomatizado.pages.HomeClienteLogadoPage;
import projeto.bankautomatizado.pages.HomePage;
import projeto.bankautomatizado.runner.Executa;

public class LogoutTests {
	HomePage home = new HomePage();
	HomeClienteLogadoPage homeLogado = new HomeClienteLogadoPage();

	@BeforeEach
	public void antesDoTeste() {
		Executa.abrirNavegador();

	}

	@AfterEach
	public void depoisDoTeste() {
		Executa.fecharNavegador();
	}

	@Test

	public void logoutComSucesso() {
		home.login("526.128.275-94", "Teste525@");
		homeLogado.sairDaConta();

	}

}
