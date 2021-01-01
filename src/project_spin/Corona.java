package det2020;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Random;

final public class Corona {
	public static void main(String[] args) {
		// if you want to log in
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter your email or phone");
		String username = obj.nextLine();
		System.out.println("Enter your password");
		String password = obj.nextLine();
		int place = email.lastIndexOf(username);
		try {
			if (place >= 0) {
				if (password = password.get(place)) { // stoixeio pinaka
					System.out.println("Successful log in");
					question(); // eisodos sto susthma
				} else {
					throw new Exception();
				}
			} else {
				throw new ArithmeticException();
			}
		} catch (Exception e) {
			System.err.println("Wrong password");
			System.err.println("Please try again");
		} catch (ArithmeticException a) {
			System.err.println("This mail or phone does not exist");
			System.err.println("Please try again");
		}
		// if you want to sing up
		Scanner obj= new Scanner(System.in);
		try {
			System.out.print("Please enter your name*");
			String name = obj.nextLine();
		} catch (NullPointerException e) {
			System.out.print("Please make sure the name field is not empty");
		}
		try {
			System.out.println("Please enter your status:/nC for covid patient/nF for first contact*");
			String status = obj.nextLine();
		} catch (Exception e) {
			// ti eksairesh bazw edwww pou thelw mono C kai F
		}	
		//date eggrafhs
		LocalDateTime signupdate = LocalDateTime.now();  
		
		// katagrafh close contacts
		System.out.print("Close contact means:" +
				" 1) spending more than 15 minutes of face-to-face contact" +
				"within 2 metres of someone who has COVID-19, indoors or outdoors" +
				" 2) living in the same house or shared accommodation as someone who has COVID-19" +
				" 3) sitting within 2 seats of someone who has COVID-19 on public transport or an airplane");
		System.out.print("How many close contacts do you have?");
		String ccg = obj.nextLine();
		int ccnum = Integer.parseInt(ccg);
		if ccnum != 0 {
			for (int i = 0; i < ccnum; i++) {
				addContact();
			}
		}
		symptomsListing(); //katagrafh symptwmatwn (mesa sth methodo h enhmerwsh gia test)
		if (status == "C") {
			try {
				System.out.print("Please enter your SSN *")
				int ssn = obg.nextInt();
			} catch (NullPointerException e) {
				System.out.print("Please make sure you entered your SSN. Try again");
			}
			try {
				System.out.print("Please enter your email*");
				String email = obj.nextLine(); 
			} catch (NullPointerException e) {
				System.out.print("Please make sure you entered your email. Try again ");
			}
			System.out.print("Please enter you region");
			String region = obj.nextLine();
			if (region = null) {
				CovidCases patient = new CovidCases(region, ssn);
			} else {
				CovidCases patient = new CovidCases(ssn);
			}
			
		} else if (status == "F") {
			try {
				System.out.print("Please enter your verification code*");
				String ver_code = obj.nextLine();
			} catch (NullPointerException e) {
				System.out.print("please make sure you entered your verification code");
			}
			try{
				System.out.print("Please enter your email*");
				String email = obj.nextLine();
			} catch (NullPointerException e) {
				System.out.print("please make sure you entered your email");
			}	
			System.out.print("Please enter your SSN ")
			int ssn = obg.nextInt();
			if (ssn = null) {
				User us = new User(ver_code, name, name);
			} else {
				User us = new User(ver_code, name, ssn, name);
			}	
			//stelnoume password
	}
}
	






