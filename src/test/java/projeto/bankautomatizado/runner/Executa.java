package projeto.bankautomatizado.runner;

import org.openqa.selenium.chrome.ChromeDriver;

import projeto.bankautomatizado.drivers.Drivers;

public class Executa extends Drivers {

	public static void abrirNavegador() {
		driver = new ChromeDriver();
		driver.get("http://52.2.114.98/");
		driver.manage().window().fullscreen();

	}

	public static void fecharNavegador() {
		driver.quit();
	}

}
