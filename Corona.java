package det2020;

import.java.util.Scanner;

public class Corona {
	public static void main{Strings[] args} {
		// if you want to log in
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter your AMKA");
		String amka = obj.nextLine();
		System.out.println("Enter your password");
		String password = obj.nextLine();
		int place = -1;
		for (int i = 0; i <= lenght; i++) { //length: megethos pinaka
			if (amka = ..) { // stoixeio pinaka
				place = i; // thesh poy brhke to antistoixo amka ston pinaka 
				break;
			}
		}
		try {
			if (place >= 0) {
				if (password = pass[place]) { // stoixeio pinaka
					System.out.println("Successful log in");
					// eisodos sto susthma
				} else {
					throw new Exception();
				}
			} else {
				throw new ArithmeticException();
			}
		} catch (Exception e) {
			System.out.println("Wrong password");
			System.out.println("Please try again");
		} catch (ArithmeticException a) {
			System.out.println("This AMKA does not exist");
			System.out.println("Please try again");
		}
		// if you forgot your password
		System.out.println("Enter your email");
		String email = obj.nextLine();
		int emailplace = -1;
		for (int i = 0; i <= lenght; i++) {
			if (email = mail[i]) {
				emailplace = i;
				break;
			}
		}
		try {
			if (emailplace >= 0) {
				// stelnetai neos kwdikos sto email
				System.out.println("Enter your new password");
				// prepei na kratame kapou ton kwdiko pou stelnetai sto mail
				String newpassword = obj.nextLine();
				System.out.println("Enter again");
				String newpasswordcheck = obj.nextLine();
				if (newpassword = newpasswordcheck) {
					System.out.println("Your new password has been changed successfully");
				} else {
					throw new Exception();
				}
			} else {
				throw new ArithmeticException();
			}
		} catch (Exception n) {
			System.out.println("")
		}

	}
}
	






