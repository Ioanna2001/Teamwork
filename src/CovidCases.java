package project_spin;

import java.util.ArrayList;

public class CovidCases  {
	

	public CovidCases(int[] patientSymptoms, String email, int patientSsn) {
		super();
		this.patientSymptoms = patientSymptoms;
		this.email = email;
		this.patientSsn = patientSsn;
	}

	public CovidCases(String email, int patientSsn, String patientLocation) {
		super();
		this.email = email;
		this.patientSsn = patientSsn;
		this.patientLocation = patientLocation;
	}

	public CovidCases(int[] patientSymptoms, String email, int patientSsn, String patientLocation) {
		super();
		this.patientSymptoms = patientSymptoms;
		this.email = email;
		this.patientSsn = patientSsn;
		this.patientLocation = patientLocation;
	}

	public CovidCases(ArrayList<FirstContact> firstContact, String email, int patientSsn, String patientLocation) {
		super();
		this.firstContact = firstContact;
		this.email = email;
		this.patientSsn = patientSsn;
		this.patientLocation = patientLocation;
	}

	public CovidCases(String email, int patientSsn) {
		super();
		this.email = email;
		this.patientSsn = patientSsn;
	}

	public CovidCases(ArrayList<FirstContact> firstContact, String email, int patientSsn) {
		super();
		this.firstContact = firstContact;
		this.email = email;
		this.patientSsn = patientSsn;
	}

	public CovidCases(int[] patientSymptoms, ArrayList<FirstContact> firstContact, String email, int patientSsn) {
		super();
		this.patientSymptoms = patientSymptoms;
		this.firstContact = firstContact;
		this.email = email;
		this.patientSsn = patientSsn;
	}
	
	public CovidCases(int[] patientSymptoms, ArrayList<FirstContact> firstContact, String email, int patientSsn,
			String patientLocation) {
		super();
		this.patientSymptoms = patientSymptoms;
		this.firstContact = firstContact;
		this.email = email;
		this.patientSsn = patientSsn;
		this.patientLocation = patientLocation;
	}
	

	
	protected static int [] symptoms_counter;
	private int[] patientSymptoms = new int[13];
	FirstContact.makelist();
	protected static ArrayList<CovidCases> cases = new ArrayList<CovidCases>();
	protected ArrayList<FirstContact> firstContact = new ArrayList<FirstContact>();
	private static ArrayList<String> location = new ArrayList<String>();
	private static int [] ssn; // εδω θα ειναι η βαση δεδομενων των κρουσματων
	private static ArrayList<String> password = new ArrayList<String>();
	protected static ArrayList<String> patinentEmails = new ArrayList<String>();
	protected String email;
	private int patientSsn;
	protected static int patientCounter;
	private String patientLocation;
	
	
	
	
	

	
	

	
	
	



	
	

}
