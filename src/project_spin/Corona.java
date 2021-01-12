package project_spin;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Random;

public class Corona {
	public static void main(String[] args) {
		Ssn.updateSsn();
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the EODY Platform Covid Tracker");
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
		return;
		}
	}
	// if you want to log in
	public static void login() {
		String status;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter your email:");
		String username = obj.nextLine();
		System.out.println("Enter your password:");
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
		String name;
		//an to name einai null petaei exception
		try {
			System.out.print("Please enter your name*");
			name = obg.nextLine();
			if (name == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			System.out.print("Please make sure the name field is not empty");
			while (name ==  null) {
				System.out.print("Please enter your name*");
				name = obg.nextLine();
			}
		}
		//an to status einai null h invalid petaei error
		String status;
		try {
			System.out.println("Please enter your status:/nC for covid patient/nF for first contact*");
			status = obg.nextLine();
			if (status == null) {
				throw new NullPointerException();
			}
			while (!(status.equals("C") || (status.equals("F")))) {
				System.out.println("Invalid answer.");
				System.out.println("Please enter your status:/nC for covid patient/nF for first contact*");
				status = obg.nextLine();
				if (status == null) {
					throw new NullPointerException();
				}
			}
		} catch (NullPointerException e) {
			System.out.print("Please make sure the name field is not empty");
			while (name ==  null) {
				System.out.println("Please enter your status:/nC for covid patient/nF for first contact*");
				status = obg.nextLine();
				while (!(status.equals("C") || (status.equals("F")))) {
					System.out.println("Invalid answer.");
					System.out.println("Please enter your status:/nC for covid patient/nF for first contact*");
					status = obg.nextLine();
					if (status == null) {
						throw new NullPointerException();
					}
				}
			}
		} 
		// katagrafh close contacts
		/**System.out.print("Close contact means:" +
				" 1) spending more than 15 minutes of face-to-face contact" +
				"within 2 metres of someone who has COVID-19, indoors or outdoors" +
				" 2) living in the same house or shared accommodation as someone who has COVID-19" +
				" 3) sitting within 2 seats of someone who has COVID-19 on public transport or an airplane");
		System.out.print("How many close contacts do you have?");
		int ccnum = obg.nextInt();
		if (ccnum != 0) {
			for (int i = 0; i < ccnum; i++) {
				User.addContact();
			}
		}
		user.symptomsListing(); //katagrafh symptwmatwn (mesa sth methodo h enhmerwsh gia test)**/
		//sing up covid case user
		if (status.equals("C")) {
			//CovidCase object
			int ssn;
			try {
				//an to ssn exei ligotera apo 6 pshfia petaei exception
				System.out.print("Please enter your SSN *");
				ssn = obg.nextInt();
				if (String.valueOf(ssn).length() != 6) {
					throw new WrongAnswerException();
				}
			} catch (WrongAnswerException exc) {
				System.out.print("Please make sure the SSN field is not empty");
				while (String.valueOf(ssn).length() != 6) {
					System.out.print("Please enter your SSN*");
					ssn = obg.nextInt();
				}
			}
			//tsekarei pws to ssn poy edwse o xrhsths yparxei sth bash dedomenwn
			//kai pws den exei hdh kanei sign up (CovidCases.ckeckSsn method)
			boolean check = CovidCases.checkSsn(ssn);
			if (check == false) {
				System.out.println("Not Valid sign up");
				return;
			}
			//o xrhsths eisagei to email
			String email;
			try {
				System.out.print("Please enter your email (example: user@test.com)*");
				email = obg.nextLine(); 
				//an to mail den einai valid petaei exception
				if (isValid(email) == false) {
					throw new WrongAnswerException();
				}
			} catch (WrongAnswerException exce) {
				System.out.print("Please make sure you entered a valid email. Try again ");
				do {
					System.out.println("Please enter your email (example: user@test.com)*");
					email = obg.nextLine();
				} while (isValid(email) == false);
			}
			//stelnetai to mail ston xrhsth
			SendEmail sendEmail = new SendEmail(email);
			sendEmail.covidCaseMail();
			//TODO: verify code, create CovidCase object, add contacts etc
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

	protected static boolean isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 




