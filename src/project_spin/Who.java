package project_spin;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;

import javax.tools.DocumentationTool.Location;

import project_spin.*;
import project_spin.CovidCases.CasePrediction;

public class Who {

	int countDead; // posoi nekroi sthn efarmogh
	int countCured; // posoi therapeumenoi sthn efarmogh
	int agd[]; // age group dead, se kathe hlikiaki omada
	final String agegroups[] = { "0-19", "20-39", "40-59", "60-79", "80+" };

	public void printPatientCount() {
		// ektipwnei ola ta krousmata tis efarmogis
		System.out.println("The number of covid patients registered in our application are:");
		System.out.println(CovidCases.getPatientCounter());
	}

	public void sufficientSample() {
		// pou tha to kaloume??
		// elegxei kai proeidopoiei an ta krousmata tis efarmogis mas einai liga
		// etsi vste na einai aksiopista ta statistika
		if (CovidCases.getPatientCounter() < 1000) {
			System.out.println(
					"Our statistic sample is less than 1000. The results produced may not lead to accurate conclusions.");
		}
	}

	public void printDeaths() {
		// ektipwnei oloys toys nekrous apo covid apo tin efarmogi mas
		System.out.println("The number of deaths due to covid in our application are:");
		System.out.println(deathCount());
	}

	public void printCured() {
		// ektipwnei oloys osous exoun anarrwsei apo covid apo tin efarmogi mas
		System.out.println("The number of cured covid patients in our application are:");
		System.out.println(curedCount());
	}

	public int deathCount() {
		// metraei tous nekrous apo covid
		if (CovidCases.getStatus() == 1) {
			countDead = +1;
			return countDead;
		}
	}

	public int curedCount() {
		// metraei osous exoun therapeutei apo covid
		if (CocvidCases.getStatus() == 0) {
			countCured = +1;
			return countCured;
		}
	}

	public double symptomsPercentage() {
		// vriskei to pososto emfanisis tou kathe symptom
		double perc[];
		for (int i = 0; i <= User.symptomsList.length(); i++) {
			perc[i] = CovidCases.symptoms_counter(i) / CovidCases.getPatientCounter() * 100;
		}
		return perc;
	}

	protected int[][] symptomsFrequency() {
		
		double perc = symptomsPercentage();
		int[] max = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		for (int i = 0; i < counter.length; i++) {
			for (int j = i+1; j < perc.length; j++) {
				if (perc[j] > perc[i]) {
			            int temp;
				    temp = perc[i];
				    perc[i] = perc[j];
				    perc[j] = temp;
				    temp = max[i];
				    max[i] = max[j];
				    max[j] = temp;
				}
			}
		}
		int[][] sym = new int {{perc},{max}}
		return sym; //ftiaxnoume disdiastato pinaka sym me to pososto forwn pou exei 
		//parousiastei ena symptom kai dipla ton deikti tou symptomatos
	}

	public void frequentSymptoms() {
	 //typwnei thn seira syxnothtas twn symptomatwn 
		for (i=0; i<=sym.length(); i++) {
			System.out.println(sym[i][0] + "% of our registered patients have experienced" User.symptomsList[sym[i][1]]);
		 }
	}

	public void ageMortality() {
		// otan kaneis update sto status
		// kalei tin ageGroups gia tous nekrous tis efarmogis
		if (CovidCases.getStatus() == 1) {
			ageGroups(agd);
		}
	}

	public int[] ageGroups(int[] a) {
		// mallon tha prepei na kaleitai apo tin covidcases + na ftiatxei enas pinakas
		// me to count twn atomwn kathe ilikiakis omadas
		// dimiourgei pinakes plithismou se kathe ilikiaki omada
		if (CovidCases.age >= 0 && CovidCases.age <= 19) {
			a[0] = +1;
		} else if (CovidCases.age >= 20 && CovidCases.age <= 39) {
			a[1] = +1;
		} else if (CovidCases.age >= 40 && CovidCases.age <= 59) {
			a[2] = +1;
		} else if (CovidCases.age >= 60 && CovidCases.age <= 79) {
			a[3] = +1;
		} else if (CovidCases.age >= 80) {
			a[4] = +1;
		}
		return a;
	}

	public double deathPercentagePerAge (int num) {
		//vriskei to pososto twn nekrwn apo covid tis efarmogis mas ana ilikiako group
		return double dperc_ag = countDead / CovidCases.ageGroups() * 100; //xreiazomaste edw ton pinaka pou tha ftiaxtei apo tin covidcases
		}

	public void deathsPerAge() {
		// kalei tin deathPercentage gia kathe ilikiako group kai ektypwnei tin
		// thnisimotita tou
		for (int i = 0; i <= 4; i++) {
			System.out.println(deathPercentage(agd[i]) + "% of this age group:" + agegroups[i] + "have passed away.");
		}
	}

	public void printAgeAverage() {
		// typwnei ton meso oro ilikias twn asthenwn
		System.out.println(CovidCases.ageAverage() + "is the average age of our registered covid patients.");
	}

	public void printAgeAveragePerSymptom() {
		// typwnei ton meso oro ilikas twn asthenwn ana symptwma
		for (i = 0; i <= User.symptomsList.length(); i++) {
			System.out.println(ageAveragePerSymptom.counter[i]
					+ "is the average age of our registered covid patients who have experienced"
					+ User.symptomsList[i]);
		}
	}

	/*
	 * STATISTIKA STOIXEIA arithmos kroysmatwn arithmos kroysmatwn ana perioxh pio
	 * syxna symptwmata pososto thanatwn pososto therapeymenwn
	 */
	protected int getPatientCounter() {
		return CovidCases.patientCounter;
	}

	// deixnei gia thn topothesia pou bazeis ta kroysmata poy exei
	protected int casesPerLocation(Location l) {
		int counter = 0;
		for (CovidCases cc : CovidCases.cases) {
			if (cc.getPatientLocation().equals(l)) {
				counter++;
			}
		}
		return counter;
	}

	// epistrefei enan pinaka opoy h kathe thesh antistoixei
	// se mia perioxh kai dexnei th syxnothta twn kroysmatwn gia oles tis perioxes
	protected int[] casesForAllLocations() {
		int i = 0;
		int counter[] = new int[CovidCases.location_counter.length];
		for (Location l : Location.values()) {
			counter[i] = casesPerLocation(l);
			i++;
		}
		return counter;
	}

	public static void printCasesPerLocation(Location i) {
		System.out.println(casesPerLocation(i) + " exist in " + i);
	}

	public static void printCasesForAllLocations() {
		int counter[] = casesForAllLocations;
		for (i = 1; i <= 13; i++) {
			System.out.println(Location.values()[i] + " has " + counter[i] + " cases.");
		}
	}

	protected void percentageOfDeaths() {
		double x = 0;
		try {
			x = ((double) CovidCases.getDeaths() / (double) CovidCases.patientCounter) * 100;
			System.out.println(x + "% of our registered covid patients have passed away.");
		} catch (ArithmeticException e) {
			System.err.println("We have 0 patients in our application.");
		}
	}

	protected void percentageOfCured() {
		double x = 0;
		try {
			x = ((double) CovidCases.getCured() / (double) CovidCases.patientCounter) * 100;
			System.out.println(x + "% of our registered covid patients have been cured.");
		} catch (ArithmeticException e) {
			System.err.println("We have 0 patients in our application.");
		}
	}

	protected void ageAverage() {
		int x = 0;
		for (int i : CovidCases.age) {
			x += i;
		}
		try {
			x = (x / CovidCases.patientCounter);
			System.out.println("The average age of the patients is " + x);
		} catch (ArithmeticException e) {
			System.err.println("We have 0 patients in our application.");
		}
	}

	protected void ageAveragePerSymptom() {
		int[] counter = new int[13];
		for (CovidCases i : CovidCases.cases) {
			for (int j = 0; j < 13; j++) {
				if (i.symptoms[j] == 1) {
					counter[j] += i.getPatientAge();
				}
			}
		}
		try {
			for (int i = 0; i < 13; i++) {
				counter[i] /= CovidCases.patientCounter;
				System.out.println("The average age of people who have experienced " + User.symptomsList[i] + " is" + counter[i]);
			}
		} catch (ArithmeticException e) {
			System.err.println("We have 0 patients in our application.");
		}
	}

	/*
	 * **Least Squares Method** static variables
	 */
	// prosthesh hmerwn apo 1/3/2020 - 31/12/2020
	static long sum_y = 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + 31;
	// prosthesh mhniaiwn kroysmatwn apo 1/3/2020 - 31/12/2020
	static long sum_x = 1307 + 1277 + 334 + 500 + 1098 + 5994 + 8222 + 20367 + 66126 + 33783;
	static long x_square = 1307 ^ 2 + 1277 ^ 2 + 334 ^ 2 + 500 ^ 2 + 1098 ^ 2 + 5994 ^ 2 + 8222 ^ 2 + 20367 ^ 2 + 66126
			^ 2 + 33783 ^ 2;
	static long xy_sum = 1307 * 31 + 1277 * 30 + 334 * 31 + 500 * 30 + 1098 * 31 + 5994 * 31 + 8222 * 30 + 20367 * 31
			+ 66126 * 30 + 33783 * 31;
	static long n = 10;
	static LocalDate date;
	static LocalDate localDate = LocalDate.of(2020, 12, 31);
	static LocalDate lastDate;

	// inner class for data manipulation
	class CasePrediction {

		public CasePrediction(LocalDate date) {
			lastDate = localDate;
			localDate = LocalDate.now();
			Who.date = date;
		}

		void updateSumY() {
			sum_y += ChronoUnit.DAYS.between(lastDate, localDate);
		}

		void updateSumX() {
			sum_x += +CovidCases.patientCounter;
		}

		void updateX_square() {
			x_square += CovidCases.patientCounter ^ 2;
		}

		void updateXY_sum() {
			xy_sum += ChronoUnit.DAYS.between(lastDate, localDate) * CovidCases.patientCounter;
		}

		void updateN() {
			n += ChronoUnit.MONTHS.between(lastDate, localDate);
		}
	}

	// o eody kalei ayth th methodo kai bazei thn hmeromhnia poy thelei na
	// problepsei posa kroysmata ua yparxoyn
	protected long getMonthlyPredection(int day, int month, int year) {
		CasePrediction prediction = new CasePrediction(LocalDate.of(day, month, year));
		prediction.updateN();
		prediction.updateSumX();
		prediction.updateSumY();
		prediction.updateX_square();
		prediction.updateXY_sum();
		// math formula
		long a = (n * xy_sum - (sum_x * sum_y)) / (n * x_square - sum_x);
		long b = ((x_square * sum_y) - (xy_sum * sum_x)) / (n * x_square - sum_x);
		return a * (n + ChronoUnit.MONTHS.between(localDate, date)) + b;
	}
}
