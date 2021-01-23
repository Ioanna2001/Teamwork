package project_spin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public final class Corona {
	static String status = null;
	static String email;
	static String name;
	static String password;
	static int ssn = 0;
	static User user = null;
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
	static void firstContact() throws Exception {
		GUI.guiFc();
	}
	//if you are a Covid-19 patient
	static void covidCase() throws Exception {
		GUI.gui4();
	}
	protected static String getStatus() {
		return status;
	}
	protected static void setStatus(String status) {
		Corona.status = status;
	}
	protected static String getEmail() {
		return email;
	}
	protected static void setEmail(String email) {
		Corona.email = email;
	}
	protected static String getName() {
		return name;
	}
	protected static void setName(String name) {
		Corona.name = name;
	}
	protected static String getPassword() {
		return password;
	}
	protected static void setPassword(String password) {
		Corona.password = password;
	}
	protected static int getSsn() {
		return ssn;
	}
	protected static void setSsn(int ssn) {
		Corona.ssn = ssn;
	}

}








