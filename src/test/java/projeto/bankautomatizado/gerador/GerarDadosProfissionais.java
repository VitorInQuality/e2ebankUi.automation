package projeto.bankautomatizado.gerador;

import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

public class GerarDadosProfissionais {

	Faker faker = new Faker(new Locale("pt-BR"));
	Random random = new Random();

	// Lista de cargos na área de tecnologia
	String[] techJobs = { "Quality Assutance", "Engenheiro de Testes" };

	// Gerar dados fictícios
	public String actualGroup = String.valueOf(faker.number().numberBetween(100000, 999999)); // Número de 8 dígitos
	public String firstGroup = String.valueOf(faker.number().numberBetween(100000, 999999)); // Número de 8 dígitos
	public String job = techJobs[random.nextInt(techJobs.length)]; // Seleciona um cargo aleatório de tecnologia
	public String salary = "R$ " + faker.number().numberBetween(1001, 10000); // Salário acima de R$ 1000
	public String professionalEmail = faker.internet().emailAddress().split("@")[0] + "@e2etreinamentos.com.br"; // E-mail
																													// com
																													// domínio
																													// específico

}
