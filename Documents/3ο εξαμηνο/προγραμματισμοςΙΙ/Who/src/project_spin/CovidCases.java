package project_spin;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
/* @Ioanna2001
 *@VasilisLazaridis
 */
public class CovidCases extends User {
	private static int cured;
	private static int deaths;
	protected static int[] symptoms_counter = new int[13];
	//counter asthenwn
	protected static int patientCounter = 0;
	protected static ArrayList<CovidCases> cases = new ArrayList<CovidCases>();
	//statikes listes gia na kratame dedomena
	//bash dedomenwn twn amka twn asthenwn
	protected static ArrayList<Integer> ssn = new ArrayList<Integer>();
	protected static ArrayList<String> email = new ArrayList<String>();
	private static ArrayList<String> location = new ArrayList<String>();
	private static ArrayList<Integer> phone = new ArrayList<Integer>();
	//pedia
	private int patientSsn;
	private String patientLocation;
	//status=0 patient cured; status=1 patient passed away
	//gia xeirismo apo eody
	private int status;
//kataskeyh kataskeyastwn 
//kataskeyasths gia osous eisagoyn location
	
	public CovidCases(String location, int ssn) {
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
		addSsn(ssn);
		addSymptoms_Counter(super.symptoms);
		addSsn(ssn);
		addPhone(super.phone);
		addEmail(super.email);
	}

	//tsekarei an yparxei to ssn sth bash dedomenwn
	protected boolean checkSsn(int s) {
		for (int i:ssn) {
			if (i == s) {
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
		ssn.add(s);
	}

//methodoi gia eisagvgh timwn stis listes
	private static void addLocation( String l) {
		if (location.contains(l)) {
			return;
		} else {
			location.add(l);
		}
		
	}

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

	protected int casesPerLocation(String l) {
		int counter = 0;
		for (CovidCases cc: cases) {
			if (cc.patientLocation.contentEquals(l)) {
				counter++;
			}
		}
		return counter;
	}

	protected int[] casesFoAllLocations() {
		int i = 0;
		int counter[] = new int[location.size()];
		for (String l:location) {
			counter[i] = casesPerLocation(l);
			i++;
		}
		return counter;
	}

	
	
}






