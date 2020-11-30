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
	private String patientPassword;
	private int patientEmail;
	private int patientPhone;
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
		if (checkEmailOrPhone == false)
			addEmail(super.email);
		 	patientEmail = User.email;
			patientPhone = null;
			addPhone(null);
		else
			patientPhone = User.phone;
			addPhone(super.phone);
			patientEmail = null;
			addEmail(null);
    }
//katakseyasths gia osous den ebalan topothesia

	public CovidCases(int ssn) {
		super();
		patientCounter ++;
		addCase(this);
		patientSsn = ssn;
		addSsn(ssn);
		addSymptoms_Counter(super.symptoms);
		patientPassword = User.password;
		patientSymptoms = User.symptoms;
		addSsn(ssn);
		if (checkEmailOrPhone == false)
			addEmail(super.email);
		 	patientEmail = User.email;
			patientPhone = null;
			addPhone(null);
		else
			patientPhone = User.phone;
			addPhone(super.phone);
			patientEmail = null;
			addEmail(null);
	}

