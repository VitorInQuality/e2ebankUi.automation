package projeto.bankautomatizado.gerador;

import java.util.Locale;

import com.github.javafaker.Faker;

public class GerarDadosPessoais {

	Faker faker = new Faker(new Locale("pt-BR"));

	// Gerar - Dados Pessoais
	public String firstName = faker.name().firstName();
	public String lastName = faker.name().lastName();
	public String email = faker.internet().emailAddress();
	public String dataBirthdayMinor = GenerateDataBirthday.generateMinorBirthday();
	public String dataBirthdayAdult = GenerateDataBirthday.generateAdultBirthday();
	public String rg = GenerateRg.generateRG();
	public String phoneNumber = faker.phoneNumber().cellPhone();
	public String address = faker.address().streetName();
	public String cep = faker.address().zipCode();
	public String number = faker.address().buildingNumber();
	public String complement = faker.address().secondaryAddress();
	public String state = faker.address().state();
	public String city = faker.address().city();

}
