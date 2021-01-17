package project_spin;

import java.util.HashMap;
//class for storing and checking passwords
class Passwords {
	private static HashMap<String, Boolean> passwords = new HashMap<String, Boolean>();

	protected static void addPassword(String pw){
		passwords.put(pw, false);
	}

	protected static boolean checkPasswordExistence(String pw) {
		if (passwords.containsKey(pw) ) {
			return false;
		} else {
			return true;
		}
	}
	protected static boolean checkPasswordVerification(String pw){
		if (passwords.containsKey(pw)) {
			if (passwords.get(pw) == false) {
				passwords.put(pw, true);
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
