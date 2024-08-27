package projeto.bankautomatizado.gerador;

import java.util.Random;

public class GenerateRg {

	private static final Random RANDOM = new Random();

	public static String generateRG() {
		StringBuilder rg = new StringBuilder();

		// Gerar os primeiros 8 dígitos
		for (int i = 0; i < 8; i++) {
			rg.append(RANDOM.nextInt(10)); // Adiciona um dígito aleatório
		}

		// Gerar os 2 últimos dígitos (verificador)
		rg.append(RANDOM.nextInt(10));
		rg.append(RANDOM.nextInt(10));

		// Formatando RG como "XX.XXX.XXX-XX"
		String formattedRG = String.format("%s.%s.%s-%s", rg.substring(0, 2), rg.substring(2, 5), rg.substring(5, 8),
				rg.substring(8, 10));

		return formattedRG;
	}

	public static void main(String[] args) {
		System.out.println("RG: " + generateRG());
	}

}
