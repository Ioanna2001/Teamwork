package project_spin;

import java.util.ArrayList;
/* @Ioanna2001
 *@VasilisLazaridis
 */
public class CovidCases extends User {
	protected static int [] symptoms_counter = new int[13];
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
	private int[] patientSymptoms;
	private String patientLocation;
//kataskeyh kataskeyastwn 
//kataskeyasths gia osous eisagoyn location
	
	public CovidCases(String location, int ssn) {
		//kalesma toy kataskeyasth ths yperklashs
		super();
		//metraei posoi einai oi asthenois
		patientCounter ++;
		addCase(this);
		//eisagwgh timwn sta paidia kai stis listes
		patientLocation = location;
		patientSsn = ssn;
		addSymptoms_Counter(super.symptoms);
		patientPassword = super.password;
		patientSymptoms = super.symptoms;
		addLocation( location);
		addSsn(ssn);
		//eisagei email h thlefwno 
		addPhone(super.phone);
		addEmail(super.email);
    }
//katakseyasths gia osous den ebalan topothesia

	public CovidCases(int ssn) {
		super();
		patientCounter ++;
		addCase(this);
		patientSsn = ssn;
		addSsn(ssn);
		addSymptoms_Counter(super.symptoms);
		patientSymptoms = User.symptoms;
		addSsn(ssn);
		addPhone(super.phone);
		addEmail(super.email);
	}
//methodoi gia eisagvgh timwn stis listes
	private static void addLocation( String l) {
		location.add(l);
	}

	private static void addSsn( Integer s) {
		ssn.add(s);
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
	
	



	
	

}

