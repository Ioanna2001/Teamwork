package project_spin;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class User {

	//attributes
	protected int [] symptoms;
	String password;
	String name;
	String userSsn;
	String username;
	ArrayList<String> contactName;
	ArrayList<String> contactPhone;
	ArrayList<String> contactEmail;
	ArrayList<Date> contactDate;
	protected static String[] symptomsList;
	private static String answer;

	//ftiaxnei ton pinaka me ta symptoms
	public static void makeSymptomsList() {

		symptomsList[0] = "Fever";
		symptomsList[1] = "Dry cough";
		symptomsList[2] = "Tiredness";
		symptomsList[3] = "Aches and pains";
		symptomsList[4] = "Sore throat";
		symptomsList[5] = "Diarrhoea";
		symptomsList[6] = "Conjuctivitis";
		symptomsList[7] = "Headache";
		symptomsList[8] = "Loss of taste or smell";
		symptomsList[9] = "A rash on skin, or discolouration of fingers or toes";
		symptomsList[10] = "Difficulty breathing or shortness of breath";
		symptomsList[11] = "Cheast pain or pressure";
		symptomsList[12] = "Loss of speech or movement";

	}

	//constructors
	public User(String password, String name, String ssn, String username) {

		this.password = password;
		this.name = name;
		this.symptoms = new int[13];
		this.userSsn = ssn;
		this.username = username;

	}

	public User(String password, String name, String username) {

		this.password = password;
		this.name = name;
		this.symptoms = new int[13];
		this.username = username;

	}

	//methods
	Scanner sc = new Scanner(System.in);

	public void addSymptoms () { //to allaksame se void - epestrefe ton pinaka me ta symptoms

		boolean wrongAnswer;
		do {
			System.out.println("Do you have any symptoms of the following?");
			for (int i = 1; i < 14; i++) {
				System.out.println(i + ". " + symptomsList[i-1]); //emfanizei ta symptwmata apo ton pinaka
			}
			System.out.println("Please write the symptoms' code numbers separated by blank spaces\n" + 
			"If you you don't have any symptoms press 0");
			answer = sc.nextLine();
			String [] parts = answer.split(" "); //pairnei ksexwrista ta symptom codes
			wrongAnswer = wrongAnswer(answer, parts); 
			if (wrongAnswer) {
				System.out.println("You seem to have pressed 0 and a different symptom code. Please reenter your answer");
				continue; //lathos apanthsh opote paei sto telos tou loop
			}
			int size = parts.length;
			int [] codes = new int [size];
			for (int i = 0; i <= size - 1; i++) {
				codes[i] = Integer.parseInt(parts[i]); // codes apo string se int
			}
			if (answer != "0") {
				System.out.println("Are you sure you want to register these?");
				for (int i=0; i<=codes.length; i++) {
					System.out.println(symptomsList[codes[i]-1]); //tsekarei oti evale swsta stoixeia
				}
				System.out.print("Press 1 for Yes\n" + "Press 2 for No\n");
				String ans = sc.next();
				if (ans == "1") {
					for (int i=0; i<=size; i++) {
						symptoms[codes[i]-1] = 1;
					}
				} else {
					wrongAnswer = true;
				}
			}
		} while (wrongAnswer) ;

	}

	private static boolean wrongAnswer(String s, String [] p) {

		boolean wrong = (s.contains("0") && (p.length > 1)); //tsek an exei 0 enw den einai to mono stoixeio
	    int len = s.length();
	    for (int i = 0; i < len; i++) {

	    	if ((Character.isLetter(s.charAt(i)))) {
	            wrong = true; //tsek an exei grammata h apanthsh
	        }

	    }
	    return wrong;
	}

	public void editContactList() {

		addContact();
		deleteContact();

	}

	public void printContacts() {

		System.out.println("These are your registered contacts");
		String showName;
		String showEmail;
		String showPhone;
		for (int i=0 ; i<=contactName.size() ; i++) {
			showName = contactName.get(i);
			showEmail = contactEmail.get(i);
			showPhone = contactPhone.get(i);
			System.out.println(showName + "   " + showEmail + "   " + showPhone);
		}

	}

	private void addContact() {

		printContacts();
		System.out.println("Do you want to add a new contact?\n" + "Press 1 for Yes\n" + "Press 2 for No\n");
		answer = sc.next();
		String ans;
		while (answer == "1") {

			System.out.println("Enter name");
			String name = sc.next();
			Date date = registerDate();
			System.out.println("Do you want to give their email or phone?\n" + "Press 1 for email\n" + "Press 2 for phone number\n");
			ans = sc.next();
			String email = null;
			String phone = null;
			if (ans == "1") {
				System.out.println("Enter their email.");
				email = sc.nextLine();
			} else {
				System.out.println("Enter their phone number.");
				phone = sc.nextLine();
			}
			contactName.add(name);
			contactPhone.add(phone);
			contactEmail.add(email);
			contactDate.add(date);
			System.out.println("Do you have any more contacts you want to register?\n" + "Press 1 for yes\n" + 
			"Press 2 for no");
			answer = sc.next();

		}
	}

	private Date registerDate() {
		
		boolean check = false;
		Date date = null;
		do {
			try {
				System.out.println("Enter the date you had contact with them. Use this pattern: DD/MM/YYYY");
				String tempDate = sc.nextLine();
				date = new SimpleDateFormat("dd/MM/yyyy").parse(tempDate); 
				check = false;
			} catch (ParseException e) {
				System.out.println("The format of the date was not right. Please enter the right format.");
				check = true;
			}
		} while (check); //mexri na einai swsto to format
		return date;

	}

	private void deleteContact() {

		System.out.println("Do you want to delete an existing contact?");
		answer = sc.next();
		while (answer == "1") {
			System.out.println("These are your registered contacts");
			printContacts();
			System.out.println("What's the name of the contact you want to erase?");
			String deleteName = sc.nextLine();
			boolean exists = contactName.contains(deleteName);
			if (exists) {
				int i = contactName.indexOf(deleteName);
				System.out.println("This contact will be permanently deleted. Are you sure you want to proceed?\n" + 
			"Press 1 for email\n" + "Press 2 for phone number\n");
				if (sc.next() == "1") {
					contactName.remove(i);
					contactEmail.remove(i);
					contactPhone.remove(i);
					contactDate.remove(i);
					System.out.println("This contact has been deleted.");
				}
			} else {
				System.out.println("There is no contact with this name.");
			}
			System.out.println("Do you want to delete another contact?");
			answer = sc.next();
		}

	}

}
