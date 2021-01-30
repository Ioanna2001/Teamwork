package project_spin;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.tools.DocumentationTool.Location;

public final class Who {

	protected void addSsn(int ssn) {
		Ssn.addSsn(ssn);
	}

	static int countDead; // posoi nekroi sthn efarmogh
	static int countCured; // posoi therapeumenoi sthn efarmogh
	static int agd[]; // age group dead, se kathe hlikiaki omada
	static final String AGE_GROUPS[] = { "0-19", "20-39", "40-59", "60-79", "80+" };
	static int ag[]; //age group, plhthysmos se kathe hlikiakh omada

	public static void printPatientCount() {
		// ektipwnei ola ta krousmata tis efarmogis
		System.out.println("The number of covid patients registered in our application are:");
		System.out.println(CovidCases.patientCounter);
	}

	public static void sufficientSample() {
		// pou tha to kaloume??
		// elegxei kai proeidopoiei an ta krousmata tis efarmogis mas einai liga
		// etsi vste na einai aksiopista ta statistika
		if (CovidCases.patientCounter < 1000) {
			System.out.println(
					"Our statistic sample is less than 1000. The results produced may not lead to accurate conclusions.");
		}
	}

	public static void printDeaths() {
		// ektipwnei oloys toys nekrous apo covid apo tin efarmogi mas
		System.out.println("The number of deaths due to covid in our application are:");
		System.out.println(countDead);
	}

	public static void printCured() {
		// ektipwnei oloys osous exoun anarrwsei apo covid apo tin efarmogi
		System.out.println("The number of cured covid patients in our application are:");
		System.out.println(countCured);
	}

	protected static void deathCount() {
		// metraei tous nekrous apo covid
		for (CovidCases i : CovidCases.cases) {
			if (i.getStatus() == 1) {
				countDead = +1;
			}
		}
	}

	protected static void curedCount() {
		// metraei osous exoun therapeutei apo covid
		for (CovidCases i : CovidCases.cases) {
			if (i.getStatus() == 0) {
				countCured = +1;
			}
		}
	}

	protected static double[] symptomsPercentage() {
		try {
		// vriskei to pososto emfanisis tou kathe symptom
			double perc[] = new double[13];
			for (int i = 0; i <= User.symptomsList.length; i++) {
				perc[i] = CovidCases.symptoms_counter[i] / CovidCases.patientCounter * 100;
			}
			return perc;
		} catch (ArithmeticException e) {
			System.out.println("We have 0 patients in our application.");
		}
		return null;
	}

	protected static double[][] symptomsFrequency() {

		double[] perc = symptomsPercentage();
		double[] max = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		for (int i = 0; i < CovidCases.symptoms_counter.length; i++) {
			for (int j = i+1; j < perc.length; j++) {
				if (perc[j] > perc[i]) {
			        double temp;
				    temp = perc[i];
				    perc[i] = perc[j];
				    perc[j] = temp;
				    temp = max[i];
				    max[i] = max[j];
				    max[j] = temp;
				}
			}
		}
		double[][] sym = {perc, max};
		return sym; //ftiaxnoume disdiastato pinaka sym me to pososto forwn pou exei 
		//parousiastei ena symptom kai dipla ton deikti tou symptomatos
	}

	public static void frequentSymptoms() {
	 //typwnei thn seira syxnothtas twn symptomatwn
		try {
			double sym[][] = symptomsFrequency();
			for (int i = 0; i < sym.length; i++) {
				System.out.println(sym[i][0] + "% of our registered patients have experienced" + 
						User.symptomsList[(int) sym[i][1]]);
			}
		} catch (Exception e) {
			System.out.println("We have 0 patients in our application.");
		}
	}

	protected static void ageMortality() {
		// otan kaneis update sto status
		// kalei tin ageGroups gia tous nekrous tis efarmogis
		for (CovidCases i : CovidCases.cases) {
			if (i.getStatus() == 1) {
				agd = ageGroups(i, agd);
			}
		}
	}

	protected static void ccInAgeGroup() {

		for (CovidCases i : CovidCases.cases) {
			ag = ageGroups(i, ag);
		}

	}

	protected static int[] ageGroups(CovidCases cc, int a[]) {
		if (cc.patientAge >= 0 && cc.patientAge <= 19) {
			a[0] =+ 1;
		} else if (cc.patientAge >= 20 && cc.patientAge <= 39) {
			a[1] =+ 1;
		} else if (cc.patientAge >= 40 && cc.patientAge <= 59) {
			a[2] =+ 1;
		} else if (cc.patientAge >= 60 && cc.patientAge <= 79) {
			a[3] =+ 1;
		} else if (cc.patientAge >= 80) {
			a[4] =+ 1;
		}
		return a;
	}

	protected static double[] deathPercentagePerAge () {
		//vriskei to pososto twn nekrwn apo covid tis efarmogis mas ana ilikiako group
		try {
			ageMortality();
			ccInAgeGroup();
			double[] dperc_ag = new double[4];
			for (int i = 0; i < 4; i++) {
				dperc_ag[i] = agd[i] / ag[i] * 100;
			}
			return dperc_ag;
		} catch (Exception e) {
			System.out.println("We have 0 patients in our application.");
		}
		return null;
	}

	public static void deathsPerAge() {
		// kalei tin deathPercentage gia kathe ilikiako group kai ektypwnei tin
		// thnisimotita tou
		try {
		double[] dper_ag = deathPercentagePerAge();
		for (int i = 0; i <= 4; i++) {
			System.out.println(dper_ag[i] + "% of this age group:" + AGE_GROUPS[i] + " have passed away.");
		}
		} catch (NullPointerException e) {
			System.out.println("We have 0 patients in our application.");
		}
	}

	/*
	 * STATISTIKA STOIXEIA arithmos kroysmatwn, arithmos kroysmatwn ana perioxh, pio
	 * syxna symptwmata, pososto thanatwn, pososto therapeymenwn
	 */
	protected static int getPatientCounter() {
		return CovidCases.patientCounter;
	}

	// deixnei gia thn topothesia pou bazeis ta kroysmata poy exei
	protected static int casesPerLocation(project_spin.Location l) {
		int counter = 0;
		try {
			for (CovidCases cc : CovidCases.cases) {
				if (cc.getPatientLocation().equals(l)) {
					counter++;
				}
			}
		} catch (NullPointerException e) {
			System.out.println("The location" + l + "has 0 cases");
		}
		return counter;
	}

	// epistrefei enan pinaka opoy h kathe thesh antistoixei
	// se mia perioxh kai dexnei th syxnothta twn kroysmatwn gia oles tis perioxes
	protected static int[] casesForAllLocations() {
		int i = 0;
		int counter[] = new int[CovidCases.location_counter.length];
		for (project_spin.Location l : project_spin.Location.values()) {
			counter[i] = casesPerLocation(l);
			i++;
		}
		return counter;
	}

	public static void printCasesPerLocation(project_spin.Location location) {
		System.out.println(casesPerLocation(location) + " exist in " + location);
	}

	public static void printCasesForAllLocations() {
		int counter[] = casesForAllLocations();
		for (int i = 1; i < 13; i++) {
			System.out.println(project_spin.Location.values()[i] + " has " + counter[i] + " cases.");
		}
	}

	public static void percentageOfDeaths() {
		double x = 0;
		try {
			x = ((double) CovidCases.getDeaths() / (double) CovidCases.patientCounter) * 100;
			System.out.println(x + "% of our registered covid patients have passed away.");
		} catch (ArithmeticException e) {
			System.out.println("We have 0 patients in our application.");
		}
	}

	public static void percentageOfCured() {
		double x = 0;
		try {
			x = ((double) CovidCases.getCured() / (double) CovidCases.patientCounter) * 100;
			System.out.println(x + "% of our registered covid patients have been cured.");
		} catch (ArithmeticException e) {
			System.out.println("We have 0 patients in our application.");
		}
	}

	public static void ageAverage() {
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

	public static void ageAveragePerSymptom() {
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
	public long getMonthlyPrediction(int day, int month, int year) {
		CasePrediction prediction = new CasePrediction(LocalDate.of(year, month, day));
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
