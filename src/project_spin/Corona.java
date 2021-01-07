package project_spin;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Random;

public class Corona {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to EODY Platform");
		System.out.println("If you want to log in press 1\nIf you want to sing up press 2");
		System.out.print("Selection: ");
		switch (in.nextInt()) 
		{
		case 1: //log in
		login();
		break;
		case 2: // sing up
		singup();
		break;
		default:
		System.err.println("Unrecognized option");
		}
	}
	// if you want to log in
	public static void login() {
		String status;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter your email");
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
	}
	// if you want to sing up
	public static void singup() {
		Scanner obg = new Scanner(System.in);
		try {
			System.out.print("Please enter your name*");
			String name = obg.nextLine();
		} catch (NullPointerException e) {
			System.out.print("Please make sure the name field is not empty");
		}
		try {
			System.out.println("Please enter your status:/nC for covid patient/nF for first contact*");
			status = obg.nextLine();
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
		int ccnum = obg.nextInt();
		if (ccnum != 0) {
			for (int i = 0; i < ccnum; i++) {
				user.addContact();
			}
		}
		user.symptomsListing(); //katagrafh symptwmatwn (mesa sth methodo h enhmerwsh gia test)
		if (status.equals("C")) {
			//CovidCase object
			try {
				System.out.print("Please enter your SSN *");
				int ssn = obg.nextInt();
			} catch (NullPointerException e) {
				System.out.print("Please make sure you entered your SSN. Try again");
			}
			try {
				System.out.print("Please enter your email*");
				String email = obg.nextLine(); 
			} catch (NullPointerException e) {
				System.out.print("Please make sure you entered your email. Try again ");
			}
			//tzo: Send verification code
			//tzo: verify code
			System.out.print("Please enter you region");
			String region = obg.nextLine();
			//tzo: ananewsh kataskeyastwn
			if (region == null) {
				CovidCases patient = new CovidCases(region, ssn);
			} else {
				CovidCases patient = new CovidCases(ssn);
			}
		} else if (status.equals("F")) {
			try {
				System.out.print("Please enter your verification code*");
				String ver_code = obg.nextLine();
			} catch (NullPointerException e) {
				System.out.print("please make sure you entered your verification code");
			}
		}
	}
	//stelnoume password
	protected static SendEmail incorrectemail() {
		SendEmail email = new SendEmail();
		email.email(password);
		//tzo: sthn metablhth username mpainei to kainoyrio email(isws)
		}
}






