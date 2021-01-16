package project_spin;

import java.util.*;
import javax.activation.DataHandler;
import java.util.Date;
import project_spin.User;

public class Tester {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		
		
	}

	private static void testWho() {
		
	}

	private static void testUser() {
		Date date = new Date();
		System.out.println(date);
	}

	private static void testCc() {
		
	}

/*	private static void testMail() throws Exception {
		SendEmail email = new SendEmail("popiroussi@icloud.com");
		email.secondContactMail();
	} */

	private static void testSsn() {
		Ssn.writeSsn(897546);
		System.out.println(GeneratePassword.generatePassword(5));
	}

}
