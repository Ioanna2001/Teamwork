package project_spin;

import java.util.*;
import javax.tools.DocumentationTool.Location;
import java.text.DateFormatSymbols;
import project_spin.*;

public class WhoMenu {
//Guyz tzo edw tsekarete kai sthn CovidCases mhn einai kamia methodos gia edw
	// nomizw pws oxi, apla mas menei gia simera na bazoume tous nekrous pou eipes
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Who who = new Who();

		String answer = menu();
		do {
			switch (answer) {
			case "1": {
				Who.printPatientCount();
			}
			case "2": {
				Who.printDeaths();
			}
			case "3": {
				Who.printCured();
			}
			case "4": {
				Who.frequentSymptoms();
			}
			case "5": {
				Who.deathsPerAge();
			}
			case "6": {
				System.out.println("Insert the location you want to see the Covid Cases of\n" + 
				"These are the locations:\n");
				int i = 1;
				for (Location l : Location.values()) {
					System.out.println(i + ". " + l);
					i++;
				}
				int loc = sc.nextInt();
				Who.printCasesPerLocation(Location.values()[loc]);
			}
			case "7": {
				Who.printCasesForAllLocations();
			}
			case "8": {
				Who.percentageOfDeaths();
			}
			case "9": {
				Who.percentageOfCured();
			}
			case "10": {
				Who.ageAverage();
			}
			case "11": {
				Who.ageAveragePerSymptom();
			}
			case "12": {
				System.out.println("Enter the month you want to predict the cases of");
				int month = sc.nextInt();
				String monthString = new DateFormatSymbols().getMonths()[month-1];
				System.out.println("Enter the year you want to predict the cases of");
				int year = sc.nextInt();
				long pr = who.getMonthlyPrediction(28, month, year);
				System.out.println("In " + monthString + " of " + year + 
						" there will probably be" + pr + "covid patients.\n");
			}

			}
			answer = menu();
		} while (answer != "0");

	}

	private static String menu() {
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

		String answer = sc.nextLine();
		return answer;

	}

}
