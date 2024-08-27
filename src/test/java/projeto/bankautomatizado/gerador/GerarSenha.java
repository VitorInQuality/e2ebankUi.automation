package projeto.bankautomatizado.gerador;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GerarSenha {

	private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
	private static final String DIGITS = "0123456789";
	private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:,.<>?";
	private static final int MIN_LENGTH = 8;
	private static final int MAX_LENGTH = 20;

	private String password;
	private String confirmPassword;

	public GerarSenha() {
		this.password = generatePassword();
		this.confirmPassword = this.password; // Garante que o confirmPassword seja igual ao password
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	private String generatePassword() {
		SecureRandom random = new SecureRandom();
		int length = random.nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH;

		List<Character> passwordChars = new ArrayList<>();
		passwordChars.add(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
		passwordChars.add(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
		passwordChars.add(DIGITS.charAt(random.nextInt(DIGITS.length())));
		passwordChars.add(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

		for (int i = 4; i < length; i++) {
			String combinedChars = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;
			char nextChar;
			do {
				nextChar = combinedChars.charAt(random.nextInt(combinedChars.length()));
			} while (isSequential(passwordChars.get(passwordChars.size() - 1), nextChar));

			passwordChars.add(nextChar);
		}

		Collections.shuffle(passwordChars, random);
		StringBuilder password = new StringBuilder();
		for (char c : passwordChars) {
			password.append(c);
		}

		return password.toString();
	}

	private boolean isSequential(char prev, char current) {
		return Math.abs(prev - current) == 1;
	}

	public static void main(String[] args) {
		GerarSenha passwordGenerator = new GerarSenha();

		System.out.println("Password: " + passwordGenerator.getPassword());
		System.out.println("Confirm Password: " + passwordGenerator.getConfirmPassword());
	}

}
