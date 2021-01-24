package project_spin.exe;

import java.util.*;
import javax.tools.DocumentationTool.Location;
import java.text.DateFormatSymbols;
import project_spin.*;

public final class WhoMenu {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Who who = new Who();

		int fAnswer;
		do {
		System.out.println("Do you wish to:\n" + "1. See our application's statistics\n" + 
		"2. Alter a patient's status\n" + "Please enter the corresponding number.");
		fAnswer = sc.nextInt();
		} while (fAnswer != 1 && fAnswer !=2 );

		if (fAnswer == 1) {
			int sAnswer = menu();

			do {
				switch (sAnswer) {
				case 1: {
					Who.printPatientCount();
					break;
				}
				case 2: {
					Who.printDeaths();
					break;
				}
				case 3: {
					Who.printCured();
					break;
				}
				case 4: {
					Who.frequentSymptoms();
					break;
				}
				case 5: {
					Who.deathsPerAge();
					break;
				}
				case 6: {
					System.out.println("Insert the location you want to see the Covid Cases of\n" + 
					"These are the locations:\n");
					int i = 1;
					for (project_spin.Location l : project_spin.Location.values()) {
						System.out.println(i + ". " + l);
						i++;
					}
					int loc = sc.nextInt();
					Who.printCasesPerLocation(project_spin.Location.values()[loc - 1]);
					break;
				}
				case 7: {
					Who.printCasesForAllLocations();
					break;
				}
				case 8: {
					Who.percentageOfDeaths();
					break;
				}
				case 9: {
					Who.percentageOfCured();
					break;
				}
				case 10: {
					Who.ageAverage();
					break;
				}
				case 11: {
					Who.ageAveragePerSymptom();
					break;
				}
				case 12: {
					System.out.println("Enter the month you want to predict the cases of");
					int month = sc.nextInt();
					String monthString = new DateFormatSymbols().getMonths()[month-1];
					System.out.println("Enter the year you want to predict the cases of");
					int year = sc.nextInt();
					long pr = who.getMonthlyPrediction(1, month, year);
					System.out.println("In " + monthString + " of " + year + 
							" there will probably be" + pr + "covid patients.\n");
					break;
				}
				}
				sAnswer = menu();
			} while (sAnswer != 0);

		} else {
			deadPatients();
		}

	}

	private static int menu() {
		Who.sufficientSample();

		System.out.println("1. Print the number of the Covid Cases in our app\n" + 
		"2. Print the number of deaths due to covid in our app\n" + 
		"3. Print the number of cured covid patients in our application\n" + 
		"4. Print each symptom appearance's percentage\n" + 
		"5. Print each age group's mortality rate\n" + 
		"6. Print the number of Covid Cases in a certain location\n" + 
		"7. Print the number of Covid Cases for all locations\n" + 
		"8. Print percentage of deaths due to covid in our app\n" + 
		"9. Print percentage of cured patients in our app\n" + 
		"10. Print age average of our users\n" + 
		"11. Print age average of users who have experienced each symptom\n" + 
		"12. Get an estimate of the Covid Cases that will appear on a certain month\n" + 
		"Enter the number for the information you are interested in.\n" + 
		"If you wish to exit press 0.");

		int answer = sc.nextInt();
		return answer;

	}

	private static void deadPatients() {
		//pairnei apo ton diaxeiristi ena ssn nekrou astheni kai thetei to status autou analogws
		int an;
		do {
			System.out.println("As the administrator, enter the ssn of the patient you wish to "
					+ "declare dead based on medical records.");
			int ans = sc.nextInt();
			for (CovidCases i : CovidCases.cases) {
				int ssn = i.getPatientSsn();
				if (ssn == ans) {
					i.setStatusDead();
					break;
				}
			}
			System.out.println("Do you wish to continue the procedure for more patients? \n "
					+ "If so, please enter 1 or else enter 0.");
			an = sc.nextInt();
		} while (an == 1);
	}

}
