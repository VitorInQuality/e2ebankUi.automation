package projeto.bankautomatizado.pages;

import org.openqa.selenium.By;

import projeto.bankautomatizado.elementos.ElementosWeb;
import projeto.bankautomatizado.gerador.GerarDadosPessoais;
import projeto.bankautomatizado.gerador.GerarDadosProfissionais;
import projeto.bankautomatizado.gerador.GerarSenha;
import projeto.bankautomatizado.metodos.MetodosWeb;

public class FormPreencherCadastroESenhaPage {

	ElementosWeb elemento = new ElementosWeb();
	MetodosWeb metodo = new MetodosWeb();

	// GERADORES DE MASSA
	GerarDadosPessoais pessoais = new GerarDadosPessoais();
	GerarDadosProfissionais profissionais = new GerarDadosProfissionais();
	GerarSenha senha = new GerarSenha();

	// ELEMENTOS DADOS PESSOAIS
	public By firstName = By.name("firstName");
	public By lastName = By.name("lastName");
	public By email = By.name("email");
	public By dataBirthday = By.name("dataBirthday");
	public By rg = By.name("rg");
	public By phoneNumber = By.name("phoneNumber");
	public By address = By.name("address");
	public By cep = By.name("cep");
	public By number = By.name("number");
	public By complement = By.name("complement");
	public By state = By.name("state");
	public By city = By.name("city");
	public By btnAvancar = By.xpath("//button[text()='Avançar']");

	/**
	 * Esse método preenche os dados pessoais com uma massa automatizada
	 */
	public void preencherDadosPessoais() {
		metodo.esperarPorElemento(firstName);
		metodo.preencherTexto(firstName, pessoais.firstName);
		metodo.preencherTexto(lastName, pessoais.lastName);
		metodo.preencherTexto(email, pessoais.email);
		metodo.clicar(dataBirthday);
		metodo.preencherTexto(dataBirthday, pessoais.dataBirthdayAdult);
		metodo.preencherTexto(this.rg, pessoais.rg);
		metodo.clicar(phoneNumber);
		metodo.preencherTexto(phoneNumber, pessoais.phoneNumber);
		metodo.preencherTexto(address, pessoais.address);
		metodo.clicar(this.cep);
		metodo.preencherTexto(this.cep, pessoais.cep);
		metodo.preencherTexto(number, pessoais.number);
		metodo.preencherTexto(state, pessoais.state);
		metodo.preencherTexto(city, pessoais.city);
		metodo.clicar(btnAvancar);
	}

	public void preencherDadosPessoais(String primeiroNome, String segundoNome, String emailPessoal,
			String dataNascimento, String rg, String telefone, String endereco, String cep, String numeroCasa,
			String estado, String cidade) {
		metodo.esperarPorElemento(firstName);
		metodo.preencherTexto(firstName, primeiroNome);
		metodo.preencherTexto(lastName, segundoNome);
		metodo.preencherTexto(email, emailPessoal);
		metodo.clicar(dataBirthday);
		metodo.preencherTexto(dataBirthday, dataNascimento);
		metodo.preencherTexto(this.rg, rg);
		metodo.clicar(phoneNumber);
		metodo.preencherTexto(phoneNumber, telefone);
		metodo.preencherTexto(address, endereco);
		metodo.clicar(this.cep);
		metodo.preencherTexto(this.cep, cep);
		metodo.preencherTexto(number, numeroCasa);
		metodo.preencherTexto(state, estado);
		metodo.preencherTexto(city, cidade);
		metodo.clicar(btnAvancar);

	}

	// ELEMENTOS DADOS PROFISSIONAIS
	public By actualGroup = By.name("actualGroup");
	public By firstGroup = By.name("firstGroup");
	public By job = By.name("job");
	public By salary = By.xpath("//input[@placeholder='Salário']");
	public By professionalEmail = By.name("professionalEmail");
	public By btnEnviar = By.id("btnEnviar");
	public By btnVoltar = By.id("btnVoltar");

	/**
	 * Esse Método preenche os dados profissionais com uma massa automatica
	 */
	public void preencherDadosProfissionais() {
		metodo.esperarPorElemento(actualGroup);
		metodo.preencherTexto(actualGroup, profissionais.actualGroup);
		metodo.preencherTexto(firstGroup, profissionais.firstGroup);
		metodo.preencherTexto(job, profissionais.job);
		metodo.preencherTexto(salary, profissionais.salary);
		metodo.preencherTexto(professionalEmail, profissionais.professionalEmail);
		metodo.esperarPorElemento(btnEnviar);
		metodo.clicar(btnEnviar);

	}

	public void preencherDadosProfissionais(String grupoAtual, String primeroGrupo, String cargo, String salario,
			String emailProfissional) {
		metodo.esperarPorElemento(actualGroup);
		metodo.preencherTexto(actualGroup, grupoAtual);
		metodo.preencherTexto(firstGroup, primeroGrupo);
		metodo.preencherTexto(job, cargo);
		metodo.preencherTexto(salary, salario);
		metodo.preencherTexto(professionalEmail, emailProfissional);
		metodo.esperarPorElemento(btnEnviar);
		metodo.clicar(btnEnviar);

	}

	// ELEMENTOS CADASTRAR SENHA
	public By password = By.name("password");
	public By confirmPassword = By.name("confirmPassword");
	public By btnCancelar = By.xpath("//button[text()='Cancelar']");
	public By btnCadastrar = By.xpath("//button[text()='Cadastrar']");

	/**
	 * Esse preencher a senha e confirmação de senha com massa automatica
	 */
	public void preencherCadastroSenha() {
		metodo.esperarPorElemento(password);
		metodo.preencherTexto(password, senha.getPassword());
		metodo.preencherTexto(confirmPassword, senha.getConfirmPassword());
		metodo.clicar(btnCadastrar);
	}

	public void preencherCadastroSenha(String senha, String confirmarSenha) {
		metodo.esperarPorElemento(password);
		metodo.preencherTexto(password, senha);
		metodo.preencherTexto(confirmPassword, confirmarSenha);
		metodo.clicar(btnCadastrar);

	}

}
