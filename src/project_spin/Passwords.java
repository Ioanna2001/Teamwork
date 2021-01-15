package project_spin;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
class Passwords {
	/*private static ArrayList<String> passwords = new ArrayList<String>();
	 * protected static void addPassword(String pw){
	 * passwords.add(pw);
	 * }
	 */
	private static File file = new File("\"https://github.com/Ioanna2001/Teamwork/tree/main/src/project_spin/passwords//");

	protected static void writePassword(String password) {
		DataOutputStream output;
		try {
			output = new DataOutputStream(new FileOutputStream(file));
			output.writeChars(password);
			output.close();
		} catch (IOException e1) {
			System.err.println("Error in data output method: writeSsn");
		}
	}

	protected static String readPassword(){
		try {
			DataInputStream input = new DataInputStream(new FileInputStream(file));
			@SuppressWarnings("deprecation")
			String x = input.readLine();
			input.close();
			return x;
		} catch (Exception e) {
			System.err.println("Error in data input method: readSsn");
		}
		finally {
			//an to arxeio den exei allo password epistrefei null
			return null;
		}
	}
	/*
	 * protected static boolean checkPassword(String pw){
	 * for (String i : Passwords) {
	 * if (i == pw){
	 * return false;
	 * }
	 * }
	 * return true; 
	 * }
	 */

	protected static boolean checkPassword(String pw) {
		boolean flag = false;
		String input;
		do {
			input = readPassword();
			if (input.equals(pw)){
				flag = true;
			}
		} while (!(input.equals(null)));
		return flag;
	}
}
