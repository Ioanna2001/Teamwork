package project_spin;

import java.util.HashMap;
//class for storing and checking passwords
public class Passwords {
	private static HashMap<String, Boolean> passwords = new HashMap<String, Boolean>();
	//matches passwords with email
	private static HashMap<String, String> emailPasswords = new HashMap<String, String>();

	public static void addPassword(String pw, String email){
		passwords.put(pw, false);
		emailPasswords.put(pw, email);
	}

	protected static boolean checkPasswordExistence(String pw, String email) {
		if (passwords.containsKey(pw) ) {
			return false;
		} else {
			emailPasswords.put(pw, email);
			return true;
		}
	}
	public static boolean checkPasswordVerification(String pw, String email){
		if (passwords.containsKey(pw)) {
			if (passwords.get(pw) == false) {
				if (emailPasswords.get(pw).equals(email)) {
					passwords.put(pw, true);
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean emailMatchesPassword(String pw, String email) {
		if (emailPasswords.containsKey(pw)) {
			if (emailPasswords.get(pw).equals(email)) {
				return true;
			}
		}
		return false;
	}

	protected static boolean hasKey(String pw) {
		return passwords.containsKey(pw);
	}

	protected static boolean getValue(String pw) {
		return passwords.get(pw);
	}
}
