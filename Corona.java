import java.util.Scanner;
import java.time.LocalDateTime;    

public class Corona{
	
	public static void main(String[] args) {
		Scanner obj= new Scanner(System.in);
		System.out.print("Please enter your name ");
		String name = obj.nextLine();
		System.out.print("Please enter your status:C for covid patient for P proti epafi");
		String status = obj.nextLine();
		//date eggrafhs
		LocalDateTime signupdate = LocalDateTime.now();  
		//katagrafh symptwmatwn
		symptomsListing();
		// katagrafh close contacts
		System.out.print("Close contact can mean:" +
				" 1) spending more than 15 minutes of face-to-face contact" +
				"within 2 metres of someone who has COVID-19, indoors or outdoors" +
				" 2) living in the same house or shared accommodation as someone who has COVID-19" +
				" 3) sitting within 2 seats of someone who has COVID-19 on public transport or an airplane");
		System.out.print("How many close contacts do you have");
		String ccg = obj.nextLine();
		int ccnum = Integer.parseInt(ccg);
		if ccnum != 0 {
			for (int i = 0; i < ccnum; i++) {
				addContact();
			}
		if (status == "C") {
			System.out.print("Please enter your email");
			String email = obj.nextLine();
			System.out.print("Please enter your phone number");
			String phonenumber = obj.nextLine();
			System.out.print("Please enter your SSN");
			String ssng = obj.nextLine();
			int ssn = Integer.parseInt(ssng);
			System.out.print("Residence Region?");
			String region = obj.nextLine();
			CovidCases patient = new CovidCases();
			patient.email = email;
			patient.patientPhone = phonenumber;
			patient.ssn = ssn;
			//stelnoume password
		}else if (status == "P") {
			System.out.print("Please enter your verification code");
			String ver_code = obj.nextLine();
			System.out.print("Please enter your phone number");
			String phonenumber = obj.nextLine();
			System.out.print("Please enter your email");
			String email = obj.nextLine();
			
			User us = new User();
			us.password = ver_code;
			us.username = name;
			us.symptoms = new int[13];			
			//stelnoume password
		}
		//date eggrafhs
		LocalDateTime signupdate = LocalDateTime.now();  
		//katagrafh symptwmatwn
		symptomsListing();
		// katagrafh close contacts
		System.out.print("Close contact can mean:" +
				" 1) spending more than 15 minutes of face-to-face contact" +
				"within 2 metres of someone who has COVID-19, indoors or outdoors" +
				" 2) living in the same house or shared accommodation as someone who has COVID-19" +
				" 3) sitting within 2 seats of someone who has COVID-19 on public transport or an airplane");
		System.out.print("How many close contacts do you have");
		String ccg = obj.nextLine();
		int ccnum = Integer.parseInt(ccg);
		if ccnum != 0 {
			for (int i = 0; i < ccnum; i++) {
				addContact();
			}
		}
	}
}
