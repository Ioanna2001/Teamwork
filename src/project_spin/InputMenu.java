package project_spin;
import java.util.Scanner;

public class InputMenu {

	protected static void display_menu() {
	System.out.println("Enter 1 for update symptom list\nEnter 2 for update contact List\nEnter 3 for update status");
	System.out.print("Selection: ");
	}

	protected static void question(User user) {
		System.out.println("Would you like to proceed or quit?");
		System.out.println("To proceed enter 9");
		System.out.println("If you wish to quit enter 0");
		Scanner q = new Scanner(System.in);
		switch(q.nextInt())
		{
			case 0:
			System.out.println("Thank you, goodbye.");
			break;

			case 9:
			System.out.println("Please proceed.");
			inputMenu(user);
			break;

			default:
			System.err.println("Unrecognized option");
			break;
		}
		q.close();
	}

	protected static void inputMenu(User user) {			
		display_menu();
		Scanner in = new Scanner(System.in);		
		switch (in.nextInt()) {
		case 1: //Update symptom list
		user.addSymptoms(); 
		break;
		case 2: //Update contact list
		user.printContacts();
		user.editContactList(); 
		break;
		case 3: //A user becomes a Covid case
		if (user instanceof CovidCases) {
			((CovidCases) user).setStatus();
		} else {
			System.out.println("To register as a Covid-19 patient please fill in the followin fields.");
			System.out.println("Please enter your location to continue");
			Location location = Corona.checkLocation();
			int age = Corona.checkAge();
			int ssn = Corona.checkSsn();
			CovidCases cc = new CovidCases(location, ssn, user.password, user.name, user.username, age);
			user.printContacts();
			System.out.println("Enter 1 if you would like to add more contacts:");
			int answer = in.nextInt();
			if (answer == 1) {
				cc.editContactList();
			}
		}
		break; 
		default:
		System.err.println("Unrecognized option");
		break;
		}   
	}
}
