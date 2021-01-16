package project_spin;

import java.util.Scanner;

public class Corona {
	static Scanner obg = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		if (Ssn.i == 0) {
			Ssn.ssnInitiator();
		}
		
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the EODY Platform Covid Tracker");
		System.out.println("If you want to log in press 1\nIf you want to sign up press 2");
		System.out.print("Selection: ");
		switch (in.nextInt()) 
		{
		case 1: //log in
		login();
		break;
		case 2: // sing up
		signup();
		break;
		default:
		System.err.println("Unrecognized option");
		return;
		}
		obg.close();
		in.close();
	}
	// if you want to log in
	public static void login() {
		User user = null;
		String status = null;
		System.out.println("Please enter your verification code:");
		String password = obg.nextLine();
		if (Passwords.hasKey(password)) {
			if (Passwords.getValue(password) == false) {
				System.out.println("You have to sign up before loging in.");
				System.exit(0);
			}
		} else {
			int tries = 1;//user has 3 tries;
			do {
				System.out.println("Invalid code. You have " + (3 - tries) + " tries");
				System.out.println("Please enter your verification code:");
				password = obg.nextLine();
				if (Passwords.hasKey(password)) {
					if (Passwords.getValue(password) == false) {
						System.out.println("You have to sign up before loging in.");
						System.exit(0);
					}
					break;
				}
				tries ++;
			} while(tries <=3);
			if (Passwords.hasKey(password) == false) {
				System.out.println("Invalid entry.");
				System.exit(0);
			}
		}
		for (User i : User.users) {
			if (password.equals(i.password)) {
				if (i instanceof CovidCases) {
					status = "C";
					user = i;
				} else {
					status = "F";
					user = i;
				}
				break;
			}
		}
		if (status == null) {
			System.out.println();
		}
		System.out.println("Successful log in");
		InputMenu.question(user); // eisodos sto susthma
	}

	// if you want to sing up
	public static void signup() throws Exception {
		Scanner obg = new Scanner(System.in);
		String name = null;
		//an to name einai null petaei exception
		try {
			System.out.println("Please enter your name:");
			name = obg.nextLine();
			if (name == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			System.out.println("Please make sure the name field is not empty");
			while (name ==  null) {
				System.out.println("Please enter your name:");
				name = obg.nextLine();
			}
		}
		//an to status einai null h invalid petaei error
		String status = null;
		try {
			System.out.println("Please enter your status:/nC for covid patient/nF for first contact:");
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
				while (!(status.equals("C") || !(status.equals("F")))) {
					System.out.println("Invalid answer.");
					System.out.println("Please enter your status:/nC for covid patient/nF for first contact*");
					status = obg.nextLine();
					if (status == null) {
						throw new NullPointerException();
					}
				}
			}
		} 

		//sing up covid case user
		if (status.equals("C")) {
			//CovidCase object
			covidCase(name);
		} else if (status.equals("F")) {
			//User object
			firstContact(name);
		}
	}

	private static void firstContact(String name) throws Exception {
		String password = passwordCheck();
		String email = emailCheck();
		User firstContact = new User(password, name, email);
		//eisagwgh prwtwn epafwn
		contacts(firstContact);
		for (String i : firstContact.contactEmail) {
			SendEmail secondContacts = new SendEmail(i);
			secondContacts.secondContactEmail();
		}
		firstContact.addSymptoms();
		InputMenu.question(firstContact);
	}

	private static void contacts(User user) {
		// katagrafh close contacts
		System.out.print("Close contact means:" +
				" 1) spending more than 15 minutes of face-to-face contact" +
				"within 2 metres of someone who has COVID-19, indoors or outdoors" +
				" 2) living in the same house or shared accommodation as someone who has COVID-19" +
				" 3) sitting within 2 seats of someone who has COVID-19 on public transport or an airplane");
		user.editContactList();
	}

	private static String emailCheck() {
		String email;
		try {
			System.out.print("Please enter your email (example: user@test.com)*");
			email = obg.nextLine(); 
			//an to mail den einai valid petaei exception
			if (SendEmail.isValid(email) == false) {
				throw new WrongAnswerException();
			}
		} catch (Exception exce) {
			System.out.print("Please make sure you entered a valid email. Try again ");
			do {
				System.out.println("Please enter your email (example: user@test.com)*");
				email = obg.nextLine();
			} while (SendEmail.isValid(email) == false);
		}
		return email;
	}

	private static String passwordCheck() {
		String password;
		System.out.println("Please enter your verification code:");
		password = obg.nextLine();
		int tries = 1;//the user can enter the code 5 times
		while (tries <= 5 && (Passwords.checkPassword(password) == false)) {
			System.out.println("Wrong code. Please enter a valid code. You have " + (5 - tries) +" tries");
			password = obg.nextLine();
			tries ++;
		}
		if (Passwords.checkPassword(password) == false) {
			System.out.println("Invalid code.");
			System.exit(0);
		}
		return password;
	}

	protected static int checkAge() {
		int age;
		System.out.println("Please enter your age:");
		age = obg.nextInt();
		while (age == 0) {
			System.out.println("Please enter your age:");
			age = obg.nextInt();
		}
		return age;
	}

	protected static Location checkLocation() {
		Location location = null;
		System.out.print("Please enter your location");
		for (Location i : Location.values()) {
			System.out.println(i);
		}
		try {
			location = Location.valueOf(obg.nextLine());
		} catch (Exception e) {
			System.out.println("Invalid location");
		}
		return location;
	}

	protected static int checkSsn() {
		int ssn = 0;
		try {
			//an to ssn exei ligotera apo 6 pshfia petaei exception
			System.out.print("Please enter your SSN:");
			ssn = obg.nextInt();
			if (String.valueOf(ssn).length() != 6) {
				throw new WrongAnswerException();
			}
		} catch (Exception exc) {
			System.out.print("Please make sure the SSN field is filled in correctly");
			int times = 1;//o xrhsths exei 3 prospatheies na balei swsta to ssn
			while (String.valueOf(ssn).length() != 6 && times <= 3) {
				System.out.print("Please enter your SSN. You have " + (3 - times) + " tries");
				ssn = obg.nextInt();
				times ++;
			}
		}
		//tsekarei pws to ssn poy edwse o xrhsths yparxei sth bash dedomenwn
		//kai pws den exei hdh kanei sign up (CovidCases.ckeckSsn method)
		if (Ssn.checkSsn(ssn) == false) {
			System.out.println("Invalid sign up ssn");
			System.exit(0);
		}
		return ssn;
	}

	private static void covidCase(String name) throws Exception {
		int ssn = checkSsn();
		//o xrhsths eisagei to email
		String email = emailCheck();
		//stelnetai to mail ston xrhsth
		SendEmail sendEmail = new SendEmail(email);
		sendEmail.covidCaseMail();
		//afoy stalei o xrhsths bazei to verification code
		String password = passwordCheck();
		//Eisagwgh perioxhs
		Location location = checkLocation();
		//eisagwgh age
		int age = checkAge();
		CovidCases patient = null;
		//dhmiourgia antikeimenou CovidCase
		if (location == null) {
			patient = new CovidCases(ssn, password, name, email, age);
		} else {
			patient = new CovidCases(location, ssn, password, name, email, age);
		}
		//eisagwgh prwtwn epafwn
		contacts(patient);
		for (String i : patient.contactEmail) {
			SendEmail firstContacts = new SendEmail(i);
			firstContacts.firstContactMail();
		}
		patient.addSymptoms();
		InputMenu.question(patient);
	}
}








