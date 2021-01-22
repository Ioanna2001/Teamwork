package project_spin;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class User {
	//attributes
	protected static ArrayList<String> userPasswords = new ArrayList<String>();
	protected static ArrayList<User> users = new ArrayList<User>();
	protected String password; //kwdikos gia eisodo sthn efarmogh
	protected String name; 
	protected String username; //einai to email
	protected ArrayList<String> contactName = new ArrayList<String>(); //lista me tis epafes kathe user (deuteres epafes)
	protected ArrayList<String> contactEmail = new ArrayList<String>();; //lista me ta emails twn epafwn kathe user
	//mallon oxi
	ArrayList<Date> contactDate; //lista - hmeromhnia epafhs me thn kathe epafh kathe user
	protected int [] symptoms; //pinakas 0-1 me ta symptoms
	protected static final String[] symptomsList = {"Fever", "Dry cough", "Tiredness", "Aches and pains", "Sore throat", 
			"Diarrhoea", "Conjuctivitis", "Headache", "Loss of taste or smell", 
			"A rash on skin, or discolouration of fingers or toes", "Difficulty breathing or shortness of breath", 
			"Cheast pain or pressure", "Loss of speech or movement"};
	private static String answer; //genika to xrhsimopoioume pantou so here it is

	/* PINAKAS SYMPTWMATWN
	symptomsList = new String[13];
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
	*/

	//constructors
	public User(String password, String name, String username) {

		this.password = password;
		userPasswords.add(password);
		this.name = name;
		this.symptoms = new int[13];
		this.username = username;
		users.add(this);

	}

	//methods
	Scanner sc = new Scanner(System.in);

	//dexetai enan pinaka me ints kai typwnei ta antistoixa symptwmata (symptomsList[i-1])
	//xrhsimopoieitai sthn addSymptoms
	private void printSymptoms(int [] s) { //orisma: pinakas me ta codes twn symptwmatwn

		int n = s.length;
		for (int i = 0; i < n; i++) {
			System.out.println(s[i] + ". " + symptomsList[s[i]-1]);
		}

	}

	//thn kalei h main gia na prosthesei o xrhsths symptwmata
	public void addSymptoms () {
		GUI.gui8();
/*
		boolean wrongAnswer;
		do {
			System.out.println("Do you have any symptoms of the following?");
			int s [] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}; //gia na perasei sthn printSymptoms ola ta symptwmata
			printSymptoms(s); //typwnei ta symptwmata
			System.out.println("Please write the symptoms' code numbers separated by blank spaces\n" + 
			"If you you don't have any symptoms press 0");
			answer = sc.nextLine(); //skanarei apanthsh

			String [] parts = answer.split(" "); //pairnei ksexwrista ta symptom codes

			wrongAnswer = wrongAnswer(answer, parts); //elegxei an einai egkyro to input
			if (wrongAnswer) {
				System.out.println("Please reenter your answer.");
				continue; //lathos apanthsh opote paei sto telos tou loop
			}
			//codes apo string se int
			int size = parts.length;
			int [] codes = new int [size];
			for (int i = 0; i <= size - 1; i++) {
				codes[i] = Integer.parseInt(parts[i]);
			}

			if (answer != "0") {
				System.out.println("Are you sure you want to register these?");
				printSymptoms(codes); //typwnei ta symptwmata pou eishgage o user gia epivevaiwsh
				System.out.print("Press 1 for Yes\n" + "Press 2 for No\n");
				String ans = sc.next();
				if (ans == "1") {
					//proxwraei sthn kataxwrhsh symptwmatwn
					for (int i=0; i<=size; i++) {
						symptoms[codes[i]-1] = 1;
					}
				} else {
					wrongAnswer = true; //o xrhsths den epivevaiwse opote pame sthn arxh tou loop
				}
			}
		} while (wrongAnswer) ; */

	}

	// xrhsimopoieitai sthn addSymptoms
	private static boolean wrongAnswer(String s, String [] p) {

		boolean wrong = true;
		if (s.contains("0") && (p.length > 1)) { //tsek an exei polla symptoms KAI to 0 - lathos input
			wrong = true;
			System.out.println("You seem to have pressed and a different symptom code."); //enhmerwnei gia to lathos
		}
	    int len = s.length();
	    for (int i = 0; i < len; i++) {

	    	if ((Character.isLetter(s.charAt(i)))) { //tsek an exei grammata h apanthsh
	            wrong = true;
	            System.out.println("You seem to have pressed some characters."); //enhmerwnei gia to lathos
	        }

	    }
	    return wrong; //epistrefei true an einai lathos to user input
	}

	//thn kalei h main an o user thelei na tropopoihsh thn lista epafwn
	public void editContactList() {

		addContact();
	//	deleteContact();

	}

	// ektupwnei tis hdh katagegramenes epafes tou xrhsth
	public void printContacts() {

		System.out.println("These are your registered contacts");
		String showName;
		String showEmail;
		for (int i=0 ; i<=contactName.size() ; i++) {
			showName = contactName.get(i);
			showEmail = contactEmail.get(i);
			System.out.println(showName + "   " + showEmail); //print onomata kai email epafwn san katalogo
		}

	}

	protected void addContact() {

		printContacts(); //prwta emfanizei tis hdh yparxouses epafes
		System.out.println("Do you want to add a new contact?\n" + "Press 1 for Yes\n" + "Press 2 for No\n");
		answer = sc.next(); //apanthsh an thelei na prosthesei

		while (answer == "1") {

			System.out.println("Enter their name"); 
			String name = sc.next(); //onoma neas epafhs
			//kalei register date gia thn metatroph tou input se Date format
			Date date = registerDate();
			System.out.println("Enter their email address");
			String email = sc.nextLine();

			//prosthetei ta inputs stis listes tou user
			contactName.add(name);
			contactEmail.add(email);
			contactDate.add(date);

			System.out.println("Do you have any more contacts you want to register?\n" + "Press 1 for yes\n" + 
			"Press 2 for no");
			answer = sc.next();

		}
	}

	//metatrepei to String tou user input se Date format
	//xrhsimopoieitai sthn addContact
	private Date registerDate() {

		boolean wrong = false; //an einai swsto to format pou edwse o user (DD/MM/YYYY)
		Date date = null;
		do {
			try {
				System.out.println("Enter the date you had contact with them. Use this pattern: DD/MM/YYYY");
				String tempDate = sc.nextLine();
				date = new SimpleDateFormat("dd/MM/yyyy").parse(tempDate); //metatrepei se date
				wrong = false;
			} catch (ParseException e) {
				System.out.println("The format of the date was not right. Please enter the right format.");
				wrong = true;
			}

			//!!! den kserw ti bgazei auto tha to dw aurio
			//idanika emfanizei thn hmeromhnia opote o xrhsths thn epivevaiwnei :)
			System.out.println("Is this the right date?" + date + " Press 1 for yes\n" + 
					"Press 2 for no\n");
			answer = sc.nextLine();
			if (answer == "2") {
				wrong = true;
			}

		} while (wrong); //mexri na einai swsto to format
		return date;

	}

	//diagrafei mia epafh tou user
	//thn kalei h editContactList
	protected void deleteContact(int i) {

	/*	System.out.println("These are your registered contacts");
		printContacts(); //typwnei tis katagegrammenes epafes
		System.out.println("Do you want to delete an existing contact?");
		answer = sc.next();

		while (answer == "1") { //o xrhsths thelei na diagrapsei mia epafh
			System.out.println("What's the name of the contact you want to erase?");
			String deleteName = sc.nextLine();

			boolean exists = contactName.contains(deleteName); //tsekarei oti yparxei h epafh
			if (exists) {
				int i = contactName.indexOf(deleteName); //briskei to index ths epafhs stis listes tou user
				//epivevaiwnei th diagrafh - proeidopoihsh
				System.out.println("This contact will be permanently deleted. Are you sure you want to proceed?\n" + 
				"Press 1 for Yes\n" + "Press 2 No\n");
				if (sc.next() == "1") { */
					//diagrafei thn epafh
					contactName.remove(i);
					contactEmail.remove(i);
					contactDate.remove(i);
				/*	System.out.println("This contact has been deleted."); //enhmerwtiko mhnyma
				}
			} else {
				System.out.println("There is no contact with this name.");
			}
			System.out.println("Do you want to delete another contact?");
			answer = sc.next(); //synexizei to loop h teleiwnei analogws */
		}

	}


