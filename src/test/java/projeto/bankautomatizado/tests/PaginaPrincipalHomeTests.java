package projeto.bankautomatizado.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projeto.bankautomatizado.pages.HomePage;
import projeto.bankautomatizado.runner.Executa;

public class PaginaPrincipalHomeTests {

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
	public void clicarNoBtnLogin() {
		home.acessarlogin();
	}

	@Test
	public void clicarNoAbrirContaEPreencherCPFValido() {
		home.acessarAbrirConta("450.486.261-99");
	}

}
