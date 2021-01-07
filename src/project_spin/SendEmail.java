package project_spin;
import java.util.Scanner;
import java.util.Properties;
import java.util.Random;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	protected int password;
	public static void main(String[] args) {
		email("iroharakopoulou@hotmail.gr", "11111111");
	}
	String useremail;
	Scanner input = new Scanner(System.in);
	public SendEmail() {
		System.out.println("please enter your email");
		useremail= input.nextLine();
	}
	protected static SendEmail incorrectemail() {
		SendEmail email = new SendEmail();
		email.email(password);
	}
	private void email(String password) {
		String to = this.useremail;
		String from = "kalomoira869@gmail.com";
		String host = "EODY";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host); //Setup mail server
		Session session = Session.getDefaultInstance(properties); //get the default session object
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAdress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAdress(to));
			message.setSubject("Validation code");
			message.setText("This is your Validation code:", password);

			//send message
			Transport.send(message);
			System.out.prinln("Sent message successfully...");
		} catch (MessagingException mex) {
			mex.printStackTrace();
			System.err.println("incorrect email");
			Corona.incorrectemail();
		}
	}

	protected String secondContactMessage() {
		return "You have been in contact with o Covid-19 close contact.\n"
				+ "/t>Please avoid unnecessary interactions\n"
				+ "/t>Wash your hands regularly\n"
				+ "/t>Use a protective face mask when contacting others\n" + "\n" + infoMessage();
	}

	protected String firstContactMessage() {
		Random rn = new Random();
		password = rn.nextInt ((10000 + 1) - 99999) + 99999;
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
		Random rn = new Random();
		password = rn.nextInt ((10000 + 1) - 99999) + 99999;
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