package project_spin;

import java.util.ArrayList;
//class for storing and checking passwords
class Passwords {
	private static ArrayList<String> passwords = new ArrayList<String>();

	protected static void addPassword(String pw){
		passwords.add(pw);
	}

	protected static boolean checkPassword(String pw){
		for (String i : passwords) {
			if (i == pw){
				return false;
			}
		}
		return true; 
	}
}
