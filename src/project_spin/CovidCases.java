package project_spin;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
/* @Ioanna2001
 *@VasilisLazaridis
 */
class CovidCases extends User {
	//san kleidi exei to ssn toy xrhsth 
	/*h boolean timh einai true an to kroysma exei kanei sign up 
	kai exei tsekaristei to ssn toy*/
	private static HashMap<Integer, Boolean> checkedSsn = new HashMap<Integer, Boolean>();
	private static int cured;
	private static int deaths;
	protected static int[] symptoms_counter = new int[13];
	//counter asthenwn
	protected static int patientCounter = 0;
	protected static ArrayList<CovidCases> cases = new ArrayList<CovidCases>();
	//hlikia asthenwn
	protected static ArrayList<Integer> age = new ArrayList<Integer>();
	//statikes listes gia na kratame dedomena
	//bash dedomenwn twn amka twn asthenwn
	protected static ArrayList<Integer> ssn = new ArrayList<Integer>();
	//metraei posa krousmata exei kathe perifereia
	protected static ArrayList<String> email = new ArrayList<String>();
	protected static int[] location_counter = new int[13];
	//pedia
	private int patientAge;
	private int patientSsn;
	private Location patientLocation;
	//status=0 patient cured; status=1 patient passed away
	//gia xeirismo apo eody
	private int status;
//kataskeyh kataskeyastwn 
//kataskeyasths gia osous eisagoyn location
	
	public CovidCases(Location location, int s, String password, String name, String email, int age) {
		//kalesma toy kataskeyasth ths yperklashs
		this(s, password, name, email, age);
		addLocation( location);
		patientLocation = location;
    }
//katakseyasths gia osous den ebalan topothesia

	public CovidCases(int s, String password, String name, String email, int age) {
		//kalei ton kataskeyasth ths superclass
		super(password, name, email);
		//aujanei ton arithmo twn asthenwn
		patientCounter ++;
		//arxikopoiei ta pedia kai tis listes
		addCase(this);
		patientSsn = s;
		ssn.add(s);
		addSymptoms_Counter(super.symptoms);
		addEmail(email);
		patientAge = age;
		addAge(age);
	}

	//tsekarei an yparxei to ssn sth bash dedomenwn
	protected boolean checkSsn(int s) {
		for (int i:ssn) {
			if (i == s) {
				checkedSsn.put(s, true);
				return true;
			}
		}
		return false;
	}

	//afairesh ssn asthenh an giatreytei
	protected void removePatient(CovidCases cc) {
		cured ++;
		for(int i:ssn) {
			if (i == patientSsn) {
				ssn.remove(ssn.indexOf(patientSsn));
				break;
			}
		}
	}
//protected gia na thn xeirizetai kai o eody
	protected static void addSsn( Integer s) {
		
		Ssn.writeSsn(s);
		if (checkedSsn.containsValue(s) == false) {
			checkedSsn.put(s, false);
		}
	}

//methodos gia ayjhsh toy counter twn perioxwn
	private static void addLocation(Location l) {
		int i = 0;
		for (Location loc : Location.values()) {
			if (loc.equals(l)) {
				location_counter[i] ++;
			}
			i++;
		}
	}
//methodoi gia eisagwgh timwn stis listes
	private static void addEmail(String e) {
		email.add(e);
	}

	private static void addCase(CovidCases c) {
		cases.add(c);
	}

	private static void addAge(int a) {
		age.add(a);
	}
//counter sunolikwn symptwmatwn kroysmatwn
	protected static  void addSymptoms_Counter(int[] s) {
		for(int i=0;i<13;i++) {
			symptoms_counter[i] += s[i];
		}
	}
//getters setter thanatwn kai giatriwn
	protected static int getCured() {
		return cured;
	}
//o eody mporei na dwsei arithmo therapeymenwn h thanatwn
	protected static void setCured(int cured) {
		CovidCases.cured = cured;
	}

	protected static int getDeaths() {
		return deaths;
	}

	protected static void setDeaths(int deaths) {
		CovidCases.deaths = deaths;
	}
	//setters getters
	protected Location getPatientLocation() {
		return patientLocation;
	}


	protected int getPatientAge() {
		return patientAge;
	}

	//gia xeirismo apo eody
	protected void setStatus() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 0 if patient is cured or 1 if patient passed away:");
		do {
		 status = sc.nextInt();
		 if ((status != 0) || (status != 1)) {
			 System.out.println("Invalid input. Enter 0 if patient is cured"
			 						+ " or 1 if patient passed away:");
		 }
		} while((status != 0) || (status != 1));
	}

	protected int getStatus(CovidCases cc) {
		return status;
	}
}

