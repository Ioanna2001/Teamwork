package project_spin;

import java.util.ArrayList;

public class User {
	//attributes
	protected static ArrayList<String> userPasswords = new ArrayList<String>();
	public static ArrayList<User> users = new ArrayList<User>();
	protected String password; //kwdikos gia eisodo sthn efarmogh
	protected String name; 
	protected String email;
	protected ArrayList<String> contactName = new ArrayList<String>(); //lista me tis epafes kathe user (deuteres epafes)
	protected ArrayList<String> contactEmail = new ArrayList<String>();; //lista me ta emails twn epafwn kathe user
//	ArrayList<Date> contactDate; //lista - hmeromhnia epafhs me thn kathe epafh kathe user
	protected int [] symptoms; //pinakas 0-1 me ta symptoms
	protected static final String[] symptomsList = {"Fever", "Dry cough", "Tiredness", "Aches and pains", "Sore throat", 
			"Diarrhoea", "Conjuctivitis", "Headache", "Loss of taste or smell", 
			"A rash on skin, or discolouration of fingers or toes", "Difficulty breathing or shortness of breath", 
			"Cheast pain or pressure", "Loss of speech or movement"};

	//constructors
	public User(String password, String name, String email) {

		this.password = password;
		userPasswords.add(password);
		this.name = name;
		this.symptoms = new int[13];
		this.email = email;
		users.add(this);
	}

	//thn kalei h main gia na prosthesei o xrhsths symptwmata
	public void addSymptoms () {
		GUI.gui8();
	}

	//diagrafei mia epafh tou user
	public void deleteContact(int i) {
		contactName.remove(i);
		contactEmail.remove(i);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<String> getContactName() {
		return contactName;
	}

	public void setContactName(ArrayList<String> contactName) {
		this.contactName = contactName;
	}

	public ArrayList<String> getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(ArrayList<String> contactEmail) {
		this.contactEmail = contactEmail;
	}

	public int[] getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(int[] symptoms) {
		this.symptoms = symptoms;
	}
}


