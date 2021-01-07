
import java.util.*;
import javax.activation.*;

public class SendEmail {
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
}