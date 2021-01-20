package project_spin;

import java.util.*;
//import javax.activation.DataHandler;
import java.util.Date;
import project_spin.User;

public class Tester {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		testWhoMenu();
		
	}

	private static void testWho() {
		
	}

	private static void testUser() {
		Date date = new Date();
		System.out.println(date);
	}

	private static void testCc() {
		
	}

	private static void testWhoMenu() {
		WhoMenu.main(null);
	}

/*	private static void testMail() throws Exception {
		SendEmail email = new SendEmail("basileslazarides@gmail.com");
		email.covidCaseMail();
		System.out.print("Succes");
	} */ 

	

}
