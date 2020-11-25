package project_spin;

import.java.util.Scanner;

public class Corona {
	public static void main(Strings[] args) {
		// if you want to log in
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter your email or phone");
		String username = obj.nextLine();
		System.out.println("Enter your password");
		String password = obj.nextLine();
		int place = email.lastIndexOf(username);
		try {
			if (place >= 0) {
				if (password = password.get(place)) { // stoixeio pinaka
					System.out.println("Successful log in");
					// eisodos sto susthma
				} else {
					throw new Exception();
				}
			} else {
				throw new ArithmeticException();
			}
		} catch (Exception e) {
			System.err.println("Wrong password");
			System.err.println("Please try again");
		} catch (ArithmeticException a) {
			System.err.println("This mail or phone does not exist");
			System.err.println("Please try again");
		}


	}
}
	






