package projeto.bankautomatizado.metodos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import projeto.bankautomatizado.drivers.Drivers;

public class MetodosWeb extends Drivers {

	public void preencherTexto(By elemento, String texto) {
		driver.findElement(elemento).sendKeys(texto);

	}

	public void clicar(By elemento) {
		driver.findElement(elemento).click();

	}

	public void arrastarCursor(By elemento) {
		WebElement arrastarParaElemento = driver.findElement(elemento);
		new Actions(driver).moveToElement(arrastarParaElemento).perform();

	}

	public void validarTitle(String titleEsperado) {
		String titleCapturado = driver.getTitle();
		assertEquals(titleEsperado, titleCapturado);
	}

	public void validarUrl(String urlEsperado) {
		String urlCapturado = driver.getCurrentUrl();
		assertEquals(urlEsperado, urlCapturado);

	}

	public void validarTexto(By elemento, String textoEsperado) {
		String textoCapturado = driver.findElement(elemento).getText();
		assertEquals(textoEsperado, textoCapturado);

	}

	public void esperarPorElemento(By elemento) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));

	}

	public void esperarPorElemento(By elemento, int segundos) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(segundos));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));

	}

}
