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
	static int ssn = 0;
	static User user = null;
	static Location location;
	static int age;
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
	}

	static void firstContact() throws Exception {
		GUI.guiFc();
	/*	User firstContact = new User(password, name, email);
		//eisagwgh prwtwn epafwn
		contacts(firstContact);
		for (String i : firstContact.contactEmail) {
			SendEmail secondContacts = new SendEmail(i);
			secondContacts.secondContactEmail();
		}
		firstContact.addSymptoms();
		InputMenu.question(firstContact); */
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

	static void covidCase() throws Exception {
		GUI.gui4();
		/*
		//eisagwgh prwtwn epafwn
		contacts(patient);
		for (String i : patient.contactEmail) {
			SendEmail firstContacts = new SendEmail(i);
			firstContacts.firstContactMail();
		}
		patient.addSymptoms();
		InputMenu.question(patient); */
	}
	protected static String getStatus() {
		return status;
	}
	protected static void setStatus(String status) {
		Corona.status = status;
	}
	protected static String getEmail() {
		return email;
	}
	protected static void setEmail(String email) {
		Corona.email = email;
	}
	protected static String getName() {
		return name;
	}
	protected static void setName(String name) {
		Corona.name = name;
	}
	protected static String getPassword() {
		return password;
	}
	protected static void setPassword(String password) {
		Corona.password = password;
	}
	protected static int getSsn() {
		return ssn;
	}
	protected static void setSsn(int ssn) {
		Corona.ssn = ssn;
	}

}








