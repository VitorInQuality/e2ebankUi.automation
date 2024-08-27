package projeto.bankautomatizado.pages;

import org.openqa.selenium.By;

import projeto.bankautomatizado.elementos.ElementosWeb;
import projeto.bankautomatizado.metodos.MetodosWeb;

public class HomePage {

	MetodosWeb metodo = new MetodosWeb();
	ElementosWeb elemento = new ElementosWeb();

	// ELEMENTOS GLOBAIS
	By btnContinuar = By.xpath("//button[text()='Continuar']");

	// ELEMENTOS ABRIR CONTA
	By btnAbrirConta = By.xpath("//button[text()='Abrir conta']");
	By campoCPF = By.xpath("//input[@id='cpf-input']");
	By msgErrorCpf = By.id("error-message");
	By tituloDadosPessoais = By.xpath("//h2[text()='Dados Pessoais']");

	public void acessarAbrirConta(String cpf) {
		metodo.clicar(btnAbrirConta);
		metodo.esperarPorElemento(campoCPF);
		metodo.preencherTexto(campoCPF, cpf);
		metodo.clicar(btnContinuar);
		metodo.esperarPorElemento(tituloDadosPessoais);
		metodo.validarTexto(tituloDadosPessoais, "Dados Pessoais");
	}

	public void acessarAbrirConta(String cpf, String msgError) {
		metodo.clicar(btnAbrirConta);
		metodo.esperarPorElemento(campoCPF);
		metodo.preencherTexto(campoCPF, cpf);
		metodo.clicar(btnContinuar);
		String msg1 = "O CPF fornecido não é de um funcionário.";
		String msg2 = "Erro na verificação do CPF";
		String msg3 = "O CPF fornecido já está registrado como cliente.";
		metodo.esperarPorElemento(this.msgErrorCpf);
		if (msgError.equals(msg1)) {
			metodo.validarTexto(this.msgErrorCpf, msg1);
		} else if (msgError.equals(msg2)) {
			metodo.validarTexto(this.msgErrorCpf, msg2);
		} else if (msgError.equals(msg3)) {
			metodo.validarTexto(this.msgErrorCpf, msg3);
		}
	}

	// ELEMENTOS LOGIN
	By btnLogin = By.xpath("//button[text()='Login']");
	By usuario = By.xpath("//input[@name='username']");
	By senha = By.xpath("//input[@name='password']");
	By msgErrorLogin = By.xpath("//span[text()='Usuário ou senha incorretos']");
	By btnCancelarLogin = By.xpath("//button[text()='Cancelar']");
	By tituloSaldoDisponivel = By.xpath("//h1[text()='Saldo disponível:']");

	public void acessarlogin() {
		metodo.clicar(btnLogin);
		String urlPaginaLogin = "http://52.2.114.98/login";
		metodo.validarUrl(urlPaginaLogin);
	}

	public void login(String usuario, String senha) {
		acessarlogin();
		metodo.preencherTexto(this.usuario, usuario);
		metodo.preencherTexto(this.senha, senha);
		metodo.clicar(btnContinuar);
		String tituloLoginClienteLogado = "Saldo disponível:";
		metodo.esperarPorElemento(tituloSaldoDisponivel);
		metodo.validarTexto(tituloSaldoDisponivel, tituloLoginClienteLogado);

	}

	public void login(String usuario, String senha, String msgError) {
		acessarlogin();
		metodo.preencherTexto(this.usuario, usuario);
		metodo.preencherTexto(this.senha, senha);
		metodo.clicar(btnContinuar);
		String msg1 = "Usuário ou senha incorretos";
		metodo.esperarPorElemento(msgErrorLogin);
		if (msgError.equals(msg1)) {
			metodo.validarTexto(msgErrorLogin, msg1);

		}

	}

	public void cancelarLogin() {
		acessarlogin();
		metodo.clicar(btnCancelarLogin);
		String urlHome = "http://52.2.114.98/";
		metodo.validarUrl(urlHome);
	}
}