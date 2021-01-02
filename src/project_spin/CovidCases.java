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
	private static int[] location_counter = new int[13];
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
//deixnei gia thn topothesia pou bazeis ta kroysmata poy exei
	protected int casesPerLocation(Location l) {
		int counter = 0;
		for (CovidCases cc: cases) {
			if (cc.patientLocation.equals(l)) {
				counter++;
			}
		}
		return counter;
	}
//epistrefei enan pinaka opoy h kathe thesh antistoixei 
//se mia perioxh kai dexnei th syxnothta twn kroysmatwn gia oles tis perioxes
	protected int[] casesForAllLocations() {
		int i = 0;
		int counter[] = new int[location_counter.length];
		for (Location l:Location.values()) {
			counter[i] = casesPerLocation(l);
			i++;
		}
		return counter;
	}

	protected double percentageOfDeaths() {
		double x = 0;
		try {
			x = ((double) deaths / (double) patientCounter) * 100;
		}
		catch (ArithmeticException e) {
			System.err.println("0 Cases");
		}
		return x;
	}

	protected double percentageOfCured() {
		double x = 0;
		try {
			x = ((double) cured / (double) patientCounter) * 100;
		}
		catch (ArithmeticException e) {
			System.err.println("0 Cases");
		}
		return x;
	}

	protected int ageAverage() {
		int x = 0;
		for (int i : age) {
			x += i;
		}
		try {
			x = (x / patientCounter);
		}
		catch (ArithmeticException e) {
			System.err.println("0 Cases");
		}
		return x;
	}

	protected int[] ageAveragePerSymptom() {
		int[] counter = new int[13];
		for (CovidCases i : cases) {
			for (int j = 0; j < 13; j++) {
				if (i.symptoms[j] == 1) {
					counter[j] += i.patientAge;
				}
			}
		}
		try {
			for (int i = 0; i < 13; i++) {
				counter[i] /= patientCounter;
			}
		} catch (ArithmeticException e) {
			System.err.println("0 Cases");
		}
		return counter;
	}
//lest squares prediction method
	protected static long casesPrediction() {
		
		class Y {
			long sum_y = 31 /*march*/+ 30 /*april*/ + 31 /*may*/ 
					+ 30 /*june*/ + 31 /*july*/ +31 /*august*/ + 30 /*september*/
					+ 31 /*octobre*/ + 30 /*november*/ + 31 /*december*/;

			void updateSum() {
				sum_y += ChronoUnit.DAYS.between(LocalDate.of(2020, 12, 31), LocalDate.now());
			}
		}

		class X {
			long sum_x = 1307 /*march*/ + 1277 /*april*/ + 334 /*may*/ + 500 /*june*/
					+ 1098 /*july*/ + 5994 /*august*/ + 8222 /*september*/ + 20367 /*octobre*/
					+ 66126 /*november*/ + 33783 /*deecember*/;
			long x_square = 1307 ^ 2 /*march*/ + 1277 ^ 2/*april*/ + 334 ^ 2 /*may*/ + 500 ^ 2 /*june*/
					+ 1098 ^ 2 /*july*/ + 5994 ^ 2 /*august*/ + 8222 ^ 2 /*september*/ + 20367 ^ 2 /*octobre*/
					+ 66126 ^ 2 /*november*/ + 33783 ^ 2 /*deecember*/;
			long xy_sum = 1307 * 31/*march*/ + 1277 * 30/*april*/ + 334 * 31/*may*/ + 500 * 30/*june*/
					+ 1098 * 31/*july*/ + 5994 * 31/*august*/ + 8222 * 30/*september*/ + 20367 * 31/*octobre*/
					+ 66126 * 30/*november*/ + 33783 * 31/*deecember*/;

			void updateSum() {
				sum_x +=  + patientCounter;
			}

			void updateX_square() {
				x_square += patientCounter ^ 2;
			}

			void updateXY_sum() {
				xy_sum += ChronoUnit.DAYS.between(LocalDate.of(2020, 12, 31), LocalDate.now()) * patientCounter;
			}
		}

		X x = new X();
		x.updateSum();
		x.updateX_square();
		x.updateXY_sum();
		Y y = new Y();
		y.updateSum();
		long n = 10 + ChronoUnit.MONTHS.between(LocalDate.of(2020, 12, 31), LocalDate.now());
		long a = y.sum_y / n;
		long b = x.xy_sum / x.x_square;
		return a + b * 
	}
}

