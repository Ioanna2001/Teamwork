import java.util.Scanner;

public class InputMenu {
	public void display_menu() {
	System.out.println("Enter 1 for update symptom list\nEnter 2 for update contact List\nEnter 3 for update status\nEnter 4 for delete account");
	System.out.print("Selection: ");
	}

	public void question() {
		System.out.println("Would you like to proceed or quit?");
		System.out.println("To proceed enter 9");
		System.out.println("If you wish to quit enter 0.");
		Scanner q = new Scanner(System.in);
		switch(q.nextInt())
		{
			case 0:
			System.out.printl("Thank you, goodbye.");
			break;

			case 9:
			System.out.println("Please proceed.");
			new InputMenu();
			break;

			default:
			System.err.println("Unrecognized option");
			break;
		}

	}

	public InputMenu() {
	Scanner in = new Scanner(System.in);
	display_menu();
	
	
		switch (in.nextInt()) {
		case 1: //Update symptom list
		symptomsListing(); 
		break;
		case 2: //Update contact list
		editContactList(); 
		printContacts();
		break;
		case 3: //A user becomes a Covid case
		//System.out.println("Please enter your location to continue");
		System.out.println("Please enter your SSN");
		Scanner c = new Scanner(System.in);
		try {
			if (checkSsn(c)) {
			CovidCases cc = new CovidCases(c);
			} else {
			throw new Exception();
			}
		} catch (Exception w) {
			System.err.println("This SSN doesn't exist");
			System.err.println("Please try again");
		}
		symptomsListing();
		editContactList();
		printContacts();
		break; 
		case 4: //Delete account	
		System.out.println("Are you sure you want to delete? YES/NO");
		Scanner a = new Scanner(System.in);
		if (a = 'YES') {
			removePatient(cc);
			break;
		} else {
			break;
		}
		default:
		System.err.println("Unrecognized option");
		break;
		}   
	}
}
