package projeto.bankautomatizado.pages;

import org.openqa.selenium.By;

import projeto.bankautomatizado.metodos.MetodosWeb;

public class HomeClienteLogadoPage {

	MetodosWeb metodo = new MetodosWeb();

	By btnMenuSuaConta = By.xpath("//button[text()='Sua Conta']");
	By btnAtualizarDados = By.xpath("//a[text()='Atualizar dados']");
	By btnSair = By.xpath("//button[text()='Sair']");

	public void acessarMenuSuaConta() {

		metodo.esperarPorElemento(btnMenuSuaConta, 15);
		metodo.arrastarCursor(btnMenuSuaConta);
	}

	public void acessarAtualizarDados() {
		acessarMenuSuaConta();
		metodo.esperarPorElemento(btnAtualizarDados);
		metodo.clicar(btnAtualizarDados);
		metodo.validarUrl("http://52.2.114.98/atualizar-dados");
	}

	public void sairDaConta() {
		acessarMenuSuaConta();
		metodo.esperarPorElemento(btnSair, 15);
		metodo.clicar(btnSair);
		metodo.validarUrl("http://52.2.114.98/");

	}

}
