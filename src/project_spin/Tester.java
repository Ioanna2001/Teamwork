package project_spin;

import java.util.*;
import project_spin.User;

public class Tester {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		for (int i = 0; i<13; i++) {
			System.out.println(User.symptomsList[i]);
		}
		User user = new User("123", "nick angelo", "nickangelo@hotmail.com");
		user.addSymptoms();

	}

}
