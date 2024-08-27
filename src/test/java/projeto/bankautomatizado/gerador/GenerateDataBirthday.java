package projeto.bankautomatizado.gerador;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GenerateDataBirthday {

	public static String generateAdultBirthday() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 18); // Define o ano para 18 anos atrás

		// Gera um intervalo aleatório de anos, meses e dias
		long eighteenYearsAgo = calendar.getTimeInMillis();
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 82); // Define o ano para 100 anos atrás
		long oneHundredYearsAgo = calendar.getTimeInMillis();

		long randomTime = oneHundredYearsAgo + (long) (Math.random() * (eighteenYearsAgo - oneHundredYearsAgo));

		Date birthDate = new Date(randomTime);
		return new SimpleDateFormat("dd/MM/yyyy").format(birthDate);

	}

	public static String generateMinorBirthday() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 18); // Define o limite máximo como 18 anos atrás

		long eighteenYearsAgo = calendar.getTimeInMillis();
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 18); // Volta o ano para a data atual
		long now = calendar.getTimeInMillis();

		long randomTime = eighteenYearsAgo + (long) (Math.random() * (now - eighteenYearsAgo));

		Date birthDate = new Date(randomTime);
		return new SimpleDateFormat("dd/MM/yyyy").format(birthDate);
	}

}
