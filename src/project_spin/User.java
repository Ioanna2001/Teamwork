package project_spin;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime; // pws douleuei?
import java.util.Date; //pws douleuei?
import java.time.format.DateTimeFormatter; //pws douleuei?

public class User {

	//attributes
	int [] symptoms;
	String password;
	String name;
	String userSsn;
	String username;
	ArrayList<String> contactName;
	ArrayList<String> contactPhone;
	ArrayList<String> contactEmail;
	ArrayList<String> contactDate;
	protected static String[] symptomsList;
	private static String answer;

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

	//constructor
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

	public int[] symptomsListing() {

		int [] symptoms = new int [13];
		System.out.println("Do you have any symptoms of the following?\n" + 
				"1. Fever \n" + "2. Dry cough\n" + "3. Tiredness\n" + "4. Aches and pains\n" +
				"5. Sore throat\n" + "6. Diarrhoea\n" + "7. Conjuctivitis\n" + "8. Headache\n" +
				"9. Loss of taste or smell\n" + "10. A rash on skin, or discolouration of fingers or toes\n" +
				"11. Difficulty breathing or shortness of breath\n" + "12. Chest pain or pressure\n" + 
				"13. Loss of speech or movement\n" + "If you you don't have any symptoms press 0\n" + 
				"Please write the symptoms' code numbers separated by blank spaces");
		answer = sc.nextLine();
		if (answer != "0") {
			String [] parts = answer.split(" ");
			int size = parts.length;
			int [] codes = new int [size];
			for (int i = 0; i <= size - 1; i++) {
				codes[i] = Integer.parseInt(parts[i]);
			}
			for (int i=0 ; i<=size ; i++) {
				symptoms[codes[i]-1] = 1;
			}
		}
		return symptoms;

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
		while (answer == "1"){

			System.out.println("Enter name");
			String name = sc.next();
			System.out.println("Enter the date you had contact with them. Use this pattern: DD-MM-YYYY");
			String tempDate = sc.nextLine();
			Date date = new Date(); // πρέπει να δούμε πως δουλεύει το Date
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
			System.out.println("Do you have any more contacts you want to register?\n" + "Press 1 for yes\n" + 
			"Press 2 for no");
			answer = sc.next();

		}

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
