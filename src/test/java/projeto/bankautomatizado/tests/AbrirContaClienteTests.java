package projeto.bankautomatizado.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projeto.bankautomatizado.gerador.GerarDadosPessoais;
import projeto.bankautomatizado.gerador.GerarDadosProfissionais;
import projeto.bankautomatizado.gerador.GerarSenha;
import projeto.bankautomatizado.pages.FormPreencherCadastroESenhaPage;
import projeto.bankautomatizado.pages.HomePage;
import projeto.bankautomatizado.runner.Executa;

public class AbrirContaClienteTests {

	HomePage home = new HomePage();
	FormPreencherCadastroESenhaPage formulario = new FormPreencherCadastroESenhaPage();

	// Geradores
	GerarDadosPessoais pessoais = new GerarDadosPessoais();
	GerarDadosProfissionais profissionais = new GerarDadosProfissionais();
	GerarSenha senha = new GerarSenha();

	@BeforeEach
	public void antesDoTeste() {
		Executa.abrirNavegador();
	}

	@AfterEach
	public void depoisDoTeste() {
		// Executa.fecharNavegador();
	}

	@Test
	public void abrirContaClienteComSucesso() {
		home.acessarAbrirConta("450.486.261-90");
		formulario.preencherDadosPessoais(pessoais.firstName, pessoais.lastName, pessoais.email,
				pessoais.dataBirthdayAdult, pessoais.rg, pessoais.phoneNumber, pessoais.address, pessoais.cep,
				pessoais.number, pessoais.state, pessoais.city);
		formulario.preencherDadosProfissionais(profissionais.actualGroup, profissionais.firstGroup, profissionais.job,
				profissionais.salary, profissionais.professionalEmail);
		formulario.preencherCadastroSenha(senha.getPassword(), senha.getConfirmPassword());

	}

	@Test
	public void abrirContaComUmCpfnaoSendoDeUmFuncionário() {
		home.acessarAbrirConta("000.000.000-00", "O CPF fornecido não é de um funcionário.");
	}

	@Test
	public void abrirContaComCpfEmBranco() {
		home.acessarAbrirConta("", "Erro na verificação do CPF");
	}

	@Test
	public void abrirContaComCpfJaCadastrado() {
		home.acessarAbrirConta("526.128.275-95", "O CPF fornecido já está registrado como cliente.");
	}

	@Test
	public void abrirContaComCpfInvalido() {
		home.acessarAbrirConta("@", "O CPF fornecido não é de um funcionário.");
	}

	@Test
	public void abrirContaContaDadosPessoaisEmBranco() {
		home.acessarAbrirConta("450.486.261-84");
		formulario.preencherDadosPessoais("", "", "", "", "", "", "", "", "", "", "");
		formulario.preencherDadosProfissionais(profissionais.actualGroup, profissionais.firstGroup, profissionais.job,
				profissionais.salary, profissionais.professionalEmail);
		formulario.preencherCadastroSenha(senha.getPassword(), senha.getConfirmPassword());
	}

	@Test
	public void abrirContaComIdadeNaoPermitida() {
		home.acessarAbrirConta("450.486.261-85");
		formulario.preencherDadosPessoais(pessoais.firstName, pessoais.lastName, pessoais.email,
				pessoais.dataBirthdayMinor, pessoais.rg, pessoais.phoneNumber, pessoais.address, pessoais.cep,
				pessoais.number, pessoais.state, pessoais.city);
		formulario.preencherDadosProfissionais(profissionais.actualGroup, profissionais.firstGroup, profissionais.job,
				profissionais.salary, profissionais.professionalEmail);
		formulario.preencherCadastroSenha(senha.getPassword(), senha.getConfirmPassword());
	}

	@Test
	public void abrirContaInformandoEmailProfissionalDiferente() {
		home.acessarAbrirConta("450.486.261-86");
		formulario.preencherDadosPessoais(pessoais.firstName, pessoais.lastName, pessoais.email,
				pessoais.dataBirthdayAdult, pessoais.rg, pessoais.phoneNumber, pessoais.address, pessoais.cep,
				pessoais.number, pessoais.state, pessoais.city);
		formulario.preencherDadosProfissionais(profissionais.actualGroup, profissionais.firstGroup, profissionais.job,
				profissionais.salary, "rodri@gmail.com");
		formulario.preencherCadastroSenha(senha.getPassword(), senha.getConfirmPassword());
	}

	@Test
	public void abrirContaComDadosProfissionaisEmBranco() {
		home.acessarAbrirConta("450.486.261-87");
		formulario.preencherDadosPessoais(pessoais.firstName, pessoais.lastName, pessoais.email,
				pessoais.dataBirthdayAdult, pessoais.rg, pessoais.phoneNumber, pessoais.address, pessoais.cep,
				pessoais.number, pessoais.state, pessoais.city);
		formulario.preencherDadosProfissionais("", "", "", "", "");
		formulario.preencherCadastroSenha(senha.getPassword(), senha.getConfirmPassword());
	}

	@Test
	public void abrirContaComDadosProfissionaisInvalidos() {
		home.acessarAbrirConta("450.486.261-86");
		formulario.preencherDadosPessoais(pessoais.firstName, pessoais.lastName, pessoais.email,
				pessoais.dataBirthdayAdult, pessoais.rg, pessoais.phoneNumber, pessoais.address, pessoais.cep,
				pessoais.number, pessoais.state, pessoais.city);
		formulario.preencherDadosProfissionais("@", "@", "@", profissionais.salary, profissionais.professionalEmail);
		formulario.preencherCadastroSenha(senha.getPassword(), senha.getConfirmPassword());
	}

	@Test
	public void abrirContaComSenhaDiferenteDaConfirmacaoDeSenha() {
		home.acessarAbrirConta("450.486.261-86");
		formulario.preencherDadosPessoais(pessoais.firstName, pessoais.lastName, pessoais.email,
				pessoais.dataBirthdayAdult, pessoais.rg, pessoais.phoneNumber, pessoais.address, pessoais.cep,
				pessoais.number, pessoais.state, pessoais.city);
		formulario.preencherDadosProfissionais(profissionais.actualGroup, profissionais.firstGroup, profissionais.job,
				profissionais.salary, profissionais.professionalEmail);
		formulario.preencherCadastroSenha(senha.getPassword(), "Teste521@");
	}

	@Test
	public void abrirContaComSenhaEConfirmacaoDeSenhaEmBranco() {
		home.acessarAbrirConta("450.486.261-86");
		formulario.preencherDadosPessoais(pessoais.firstName, pessoais.lastName, pessoais.email,
				pessoais.dataBirthdayAdult, pessoais.rg, pessoais.phoneNumber, pessoais.address, pessoais.cep,
				pessoais.number, pessoais.state, pessoais.city);
		formulario.preencherDadosProfissionais(profissionais.actualGroup, profissionais.firstGroup, profissionais.job,
				profissionais.salary, profissionais.professionalEmail);
		formulario.preencherCadastroSenha("", "");
	}

	@Test
	public void abrirContaComSenhaSequencial() {
		home.acessarAbrirConta("450.486.261-86");
		formulario.preencherDadosPessoais(pessoais.firstName, pessoais.lastName, pessoais.email,
				pessoais.dataBirthdayAdult, pessoais.rg, pessoais.phoneNumber, pessoais.address, pessoais.cep,
				pessoais.number, pessoais.state, pessoais.city);
		formulario.preencherDadosProfissionais(profissionais.actualGroup, profissionais.firstGroup, profissionais.job,
				profissionais.salary, profissionais.professionalEmail);
		formulario.preencherCadastroSenha("123aaaA@", "123aaaA@");
	}

}
