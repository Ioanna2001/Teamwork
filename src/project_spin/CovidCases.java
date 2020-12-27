package project_spin;
import java.util.Scanner;
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
	//statikes listes gia na kratame dedomena
	//bash dedomenwn twn amka twn asthenwn
	protected static ArrayList<Integer> ssn = new ArrayList<Integer>();
	//metraei posa krousmata exei kathe perifereia
	protected static ArrayList<String> email = new ArrayList<String>();
	private static int[] location_counter = new int[13];
	private static ArrayList<Integer> phone = new ArrayList<Integer>();
	//pedia
	private int patientSsn;
	private Location patientLocation;
	//status=0 patient cured; status=1 patient passed away
	//gia xeirismo apo eody
	private int status;
//kataskeyh kataskeyastwn 
//kataskeyasths gia osous eisagoyn location
	
	public CovidCases(Location location, int ssn) {
		//kalesma toy kataskeyasth ths yperklashs
		CovidCases(ssn);
		addLocation( location);
		patientLocation = location;
    }
//katakseyasths gia osous den ebalan topothesia

	public CovidCases(int ssn) {
		//kalei ton kataskeyasth ths superclass
		super();
		//aujanei ton arithmo twn asthenwn
		patientCounter ++;
		//arxikopoiei ta pedia kai tis listes
		addCase(this);
		patientSsn = ssn;
		ssn.add(s);
		addSymptoms_Counter(super.symptoms);
		addPhone(super.phone);
		addEmail(super.email);
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
	private static void addEmail( String e) {
		email.add(e);
	}

	private static void addPhone(int p) {
		phone.add(p);
	}

	private static void addCase( CovidCases c) {
		cases.add(c);
	}
//checking if the user entered email of phone
	protected boolean checkEmailOrPhone() {
		if (super.phone == null ) {
			return false;
		}
		else {
			return true;
		}
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
/*STATISTIKA STOIXEIA
 * arithmos kroysmatwn
 * arithmos kroysmatwn ana perioxh
 * pio syxna symptwmata
 * pososto thanatwn
 * pososto therapeymenwn
 */
	protected int getPatientCounter() {
		return patientCounter;
	}

	protected int casesPerLocation(Location l) {
		int counter = 0;
		for (CovidCases cc: cases) {
			if (cc.patientLocation.equals(l)) {
				counter++;
			}
		}
		return counter;
	}

	protected int[] casesForAllLocations() {
		int i = 0;
		int counter[] = new int[location_counter.length];
		for (Location l:Location.values()) {
			counter[i] = casesPerLocation(l);
			i++;
		}
		return counter;
	}

	protected String[] symptomsFrequency() {
		String[] symptoms = super.makeSymptomsList();
		int[] counter = symptoms_counter;
		int[] max = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		for (int i = 0; i < counter.length; i++) {
			for (int j = i+1; j < counter.length; j++) {
				if (counter[j] > counter[i]) {
			            int temp;
				    temp = counter[i];
				    counter[i] = counter[j];
				    counter[j] = temp;
				    temp = max[i];
				    max[i] = max[j];
				    max[j] = temp;
				}
			}
		}
	}
}

