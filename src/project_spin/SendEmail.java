package project_spin;
import javax.activation.DataHandler;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	String from = "teamwork.covid.tracker@gmail.com";//sender
	String fromPassword = "teamwork20202021";
	protected String password;//verification code sent by email
	protected String userEmail;//recipient
	Scanner input = new Scanner(System.in);

	protected SendEmail(String email) {
		userEmail= email;
	}
//method that sends the email
	private void email(String mess) throws Exception{
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, fromPassword);
			}
		});
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
			message.setSubject("Covid Alert");
			message.setText(mess);
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void secondContactEmail() throws Exception {
		email(secondContactMessage());
	}

	protected void firstContactMail() throws Exception {
		email(firstContactMessage());
	}

	protected void covidCaseMail() throws Exception {
		email(covidCaseMessage());
	}
//custom messages
	protected String secondContactMessage() {
		return "You have been in contact with o Covid-19 close contact.\n"
				+ "%t>Please avoid unnecessary interactions\n"
				+ "%t>Wash your hands regularly\n"
				+ "%t>Use a protective face mask when contacting others\n" + "\n" + infoMessage();
	}

	protected String firstContactMessage() {
		password = String.valueOf(GeneratePassword.generatePassword(5));
		while (Passwords.checkPassword(password) == false) {
			password = String.valueOf(GeneratePassword.generatePassword(5));
		}
		Passwords.addPassword(password);
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
		password = String.valueOf(GeneratePassword.generatePassword(5));
		while (Passwords.checkPassword(password) == false) {
			password = String.valueOf(GeneratePassword.generatePassword(5));
		}
		Passwords.addPassword(password);
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

	protected static boolean isValid(String email) { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    }
}
