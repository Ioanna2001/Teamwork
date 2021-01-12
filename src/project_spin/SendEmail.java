package project_spin;

import java.util.Scanner;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	String from = "teamwork.covid.tracker@gmail.com";
	protected String password;
	protected String userEmail;
	Scanner input = new Scanner(System.in);

	protected SendEmail(String email) {
		userEmail= email;
	}

	protected void secondContactMail() {
		InternetAddress address = null;
		try {
			address = new InternetAddress(userEmail);
		} catch (AddressException e) {
			System.err.println("Problem with second contact internet address");
		}
		Properties properties = new Properties();
		Session session = Session.getDefaultInstance(properties, null);
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(from);
			message.addRecipient( Message.RecipientType.TO, address);
			message.setText(secondContactMessage());
		} catch (MessagingException e) {
			System.err.println("Problem emailing second contacts");
		}	
	}

	protected void firstContactMail() {
		InternetAddress address = null;
		try {
			address = new InternetAddress(userEmail);
		} catch (AddressException e) {
			System.err.println("Problem with second contact internet address");
		}
		Properties properties = new Properties();
		Session session = Session.getDefaultInstance(properties, null);
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(from);
			message.addRecipient( Message.RecipientType.TO, address);
			message.setText(firstContactMessage());
		} catch (MessagingException e) {
			System.err.println("Problem emailing second contacts");
		}
	}

	protected void covidCaseMail() {
		InternetAddress address = null;
		try {
			address = new InternetAddress(userEmail);
		} catch (AddressException e) {
			System.err.println("Problem with second contact internet address");
		}
		Properties properties = new Properties();
		Session session = Session.getDefaultInstance(properties, null);
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(from);
			message.addRecipient( Message.RecipientType.TO, address);
			message.setText(covidCaseMessage());
		} catch (MessagingException e) {
			System.err.println("Problem emailing second contacts");
		}	
	}

	protected String secondContactMessage() {
		return "You have been in contact with o Covid-19 close contact.\n"
				+ "/t>Please avoid unnecessary interactions\n"
				+ "/t>Wash your hands regularly\n"
				+ "/t>Use a protective face mask when contacting others\n" + "\n" + infoMessage();
	}

	protected String firstContactMessage() {
		password = GeneratePassword.generatePassword(5);
		//tsekarei pws o kwdikos den yparxei hdh
		boolean flag = Passwords.checkPassword(password);
		while (flag == false) {
			password = GeneratePassword.generatePassword(5);
			flag = Passwords.checkPassword(password);
		}
		Passwords.writePassword(password);
		return "You have been in close contact with a Covid-19 patient. "
				+ "Please follow the country's virus prevention protoco:\n"
				+ "**1** You are required carantine in your house for 14 days"
				+ ". Please avoid complete contact with anyone outside your house"
				+ "**2** Wash your hands regularly and try sterilizing your personal items seperataly\n"
				+ "**3** If any of the following symptoms occur please take a Covid-19 test immediatly:\n"
				+ User.symptomsList + "\n"
				+ "**4** Please download the Covid Tracker application\n"
				+ "**5** Sign up as a first contact\n"
				+ "**6** Enter the verification code shown below\n"
				+ "**7** Enter the contact details of the people you have been in close contact with.\n"
				+ "\t>People you have been 15 or less meters apart\n"
				+ "\t>People you have been in the same room for two hours or more\n"
				+ "**Verification code:**" + password + "\n" + infoMessage();
	}

	protected String covidCaseMessage() {
		password = GeneratePassword.generatePassword(5);
		//tsekarei pws o kwdikos den yparxei hdh
		boolean flag = Passwords.checkPassword(password);
		while (flag == false) {
			password = GeneratePassword.generatePassword(5);
			flag = Passwords.checkPassword(password);
		}
		Passwords.writePassword(password);
		return "You have been tested positive for Covid-19."
				+ "Please follow the country's virus prevention protocol:\n"
				+ "**1** You are required to carantine in you house for all t"
				+ "he time that you are experiencing Covid-19 symptoms "
				+ "and 14 days after the symptoms have stopped\n"
				+ "**2** Please avoid coming in contact with people in inside your leaving space. "
				+ "If contact is necessary please wear a protective face mask\n"
				+ "**3** Wash and sterilize your personal objects seperataly\n"
				+ "**4** Please download the Covid Tracker\n"
				+ "**5** Sign up as a Covid patient\n"
				+ "**6** Enter the verification code shown below\n"
				+ "**7** Enter the contact details of the people you have been in close contact with.\n"
				+ "\t>People you have been 15 or less meters apart\n"
				+ "\t>People you have been in the same room for two hours or more\n"
				+ "**Verification code:**" + password + "\n" + infoMessage();
	}

	protected String infoMessage() {
		return "For further questions on the Covid-19 protocol please visit the WHO website:\n"
				+ " https://www.who.int/emergencies/diseases/novel-coronavirus-2019?gclid=CjwKCAiA_9r_BRBZEiwAHZ_v11O4yqh06VEnOb2W5zrKipeeccXTDoBYTLrZU0Iv1IJlbeSQYkNyGxoCbtsQAvD_BwE";
	}
}
