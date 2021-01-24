package project_spin.exe;

import project_spin.*;

public final class Corona {
	static String status = null;
	static String email;
	static String name;
	static String password;
	static int ssn = 0;
	public static User user = null;
	static Location location;
	static int age;

	public static void main(String[] args) throws Exception {
		String pw = "12345";
		Passwords.addPassword(pw, "t8190121@aueb.gr");
		User testUser = new User(pw, "name", "t8190121@aueb.gr");//test first contact
		user = testUser;
		Ssn.ssnInitiator();
		GUI.gui();
	}
	// if you want to log in
	public static void login() {
		GUI.guiLogIn();
	}

	// if you want to sing up
	public static void signup() throws Exception {
		GUI.gui3();
	}
	//if you are a patients first contact
	public static void firstContact() throws Exception {
		GUI.guiFc();
	}
	//if you are a Covid-19 patient
	public static void covidCase() throws Exception {
		GUI.gui4();
	}
	public static String getStatus() {
		return status;
	}
	public static void setStatus(String status) {
		Corona.status = status;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		Corona.email = email;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Corona.name = name;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Corona.password = password;
	}
	public static int getSsn() {
		return ssn;
	}
	public static void setSsn(int ssn) {
		Corona.ssn = ssn;
	}
	public static Location getLocation() {
		return location;
	}
	public static void setLocation(Location location) {
		Corona.location = location;
	}
	public static int getAge() {
		return age;
	}
	public static void setAge(int age) {
		Corona.age = age;
	}

}








