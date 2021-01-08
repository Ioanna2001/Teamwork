package project_spin;

import java.util.Random;

public class GeneratePassword {
	protected static String generatePassword(int length) {
		String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      	String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
      	String specialCharacters = "!@#$";
      	String numbers = "1234567890";
      	String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
      	Random random = new Random();
      	char[] p = new char[length];

      	p[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
      	p[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
      	p[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
      	p[3] = numbers.charAt(random.nextInt(numbers.length()));
   
      	for(int i = 4; i < length; i++) {
        	p[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
     	}
     	String password = p[0];
     	
     	for (int i = 1; i < length; i++) {
     		password += p[i];
     	}
    }
}
