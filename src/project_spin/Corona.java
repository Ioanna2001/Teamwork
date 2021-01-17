package project_spin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public final class Corona {
	static Scanner obg = new Scanner(System.in);
	static String status = null;
	static String email;
	static String name;
	static String password;
	public static void main(String[] args) throws Exception {
		if (Ssn.i == 0) {
			Ssn.ssnInitiator();
		}
		GUI.gui();
		
		obg.close();
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
		GUI.gui3();
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

	private static void passwordCheck() {
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
		//stelnetai to mail ston xrhsth
		SendEmail sendEmail = new SendEmail(email);
		sendEmail.covidCaseMail();
		//afoy stalei o xrhsths bazei to verification code
		
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








