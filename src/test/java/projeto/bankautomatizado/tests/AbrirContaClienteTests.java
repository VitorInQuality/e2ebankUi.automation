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
import projeto.bankautomatizado.utils.MassaDeDados;

public class AbrirContaClienteTests {

	// Pages
	HomePage home = new HomePage();
	FormPreencherCadastroESenhaPage formulario = new FormPreencherCadastroESenhaPage();

	// Geradores
	GerarDadosPessoais pessoais = new GerarDadosPessoais();
	GerarDadosProfissionais profissionais = new GerarDadosProfissionais();
	GerarSenha senha = new GerarSenha();

	// Massa
	MassaDeDados massa = new MassaDeDados();

	@BeforeEach
	public void antesDoTeste() {
		Executa.abrirNavegador();
	}

	@AfterEach
	public void depoisDoTeste() {
		Executa.fecharNavegador();
	}

	@Test
	public void abrirContaClienteComSucesso() {
		home.acessarAbrirConta(massa.obterEExcluirCpf());
		formulario.preencherDadosPessoais();
		formulario.preencherDadosProfissionais();
		formulario.preencherCadastroSenha();

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
		home.acessarAbrirConta(massa.obterEExcluirCpf());
		formulario.preencherDadosPessoais("", "", "", "", "", "", "", "", "", "", "");
		formulario.preencherDadosProfissionais();
		formulario.preencherCadastroSenha();
	}

	@Test
	public void abrirContaComIdadeNaoPermitida() {
		home.acessarAbrirConta(massa.obterEExcluirCpf());
		formulario.preencherDadosPessoais(pessoais.firstName, pessoais.lastName, pessoais.email,
				pessoais.dataBirthdayMinor, pessoais.rg, pessoais.phoneNumber, pessoais.address, pessoais.cep,
				pessoais.number, pessoais.state, pessoais.city);
		formulario.preencherDadosProfissionais();
		formulario.preencherCadastroSenha();
	}

	@Test
	public void abrirContaInformandoEmailProfissionalDiferente() {
		home.acessarAbrirConta(massa.obterEExcluirCpf());
		formulario.preencherDadosPessoais();
		formulario.preencherDadosProfissionais(profissionais.actualGroup, profissionais.firstGroup, profissionais.job,
				profissionais.salary, "rodri@gmail.com");
		formulario.preencherCadastroSenha();
	}

	@Test
	public void abrirContaComDadosProfissionaisEmBranco() {
		home.acessarAbrirConta(massa.obterEExcluirCpf());
		formulario.preencherDadosPessoais();
		formulario.preencherDadosProfissionais("", "", "", "", "");
		formulario.preencherCadastroSenha();
	}

	@Test
	public void abrirContaComDadosProfissionaisInvalidos() {
		home.acessarAbrirConta(massa.obterEExcluirCpf());
		formulario.preencherDadosPessoais();
		formulario.preencherDadosProfissionais("@", "@", "@", profissionais.salary, profissionais.professionalEmail);
		formulario.preencherCadastroSenha();
	}

	@Test
	public void abrirContaComSenhaDiferenteDaConfirmacaoDeSenha() {
		home.acessarAbrirConta(massa.obterEExcluirCpf());
		formulario.preencherDadosPessoais();
		formulario.preencherDadosProfissionais();
		formulario.preencherCadastroSenha("Teste521#", "Teste521@");
	}

	@Test
	public void abrirContaComSenhaEConfirmacaoDeSenhaEmBranco() {
		home.acessarAbrirConta(massa.obterEExcluirCpf());
		formulario.preencherDadosPessoais();
		formulario.preencherDadosProfissionais();
		formulario.preencherCadastroSenha("", "");
	}

	@Test
	public void abrirContaComSenhaSequencial() {
		home.acessarAbrirConta(massa.obterEExcluirCpf());
		formulario.preencherDadosPessoais();
		formulario.preencherDadosProfissionais();
		formulario.preencherCadastroSenha("123aaaA@", "123aaaA@");
	}

}
