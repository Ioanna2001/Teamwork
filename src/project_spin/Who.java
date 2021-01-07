package project_spin;

import java.util.Arrays;
import java.util.Collections;
import project_spin.*;

public class Who {

	int countDead; //posoi nekroi sthn efarmogh
	int countCured; //posoi therapeumenoi sthn efarmogh
	int agd[]; // age group dead, se kathe hlikiaki omada
	final String agegroups[] = {"0-19", "20-39", "40-59", "60-79", "80+"};
	
	public void printPatientCount () {
		//ektipwnei ola ta krousmata tis efarmogis
		System.out.println("The number of covid patients registered in our application are:");
		System.out.println(CovidCases.getPatientCounter());
	}
	
	public void sufficientSample() {
		//pou tha to kaloume??
		//elegxei kai proeidopoiei an ta krousmata tis efarmogis mas einai liga
		// etsi vste na einai aksiopista ta statistika
		if (CovidCases.getPatientCounter() < 1000) {
			System.out.println("Our statistic sample is less than 1000. The results produced may not lead to accurate conclusions.");
		}	
	}
	
	public void printDeaths() {
		//ektipwnei oloys toys nekrous apo covid apo tin efarmogi mas
		System.out.println("The number of deaths due to covid in our application are:");
		System.out.println(deathCount());
	}
	
	
	public void printCured() {
		//ektipwnei oloys osous exoun anarrwsei apo covid apo tin efarmogi mas
		System.out.println("The number of cured covid patients in our application are:");
		System.out.println(curedCount());
	}
	
	public int deathCount() {
		//metraei tous nekrous apo covid
		if (CovidCases.getStatus() == 1) {
			countDead = + 1;
			return countDead;
		}
	}
	
	public int curedCount() {
		//metraei osous exoun therapeutei apo covid
		if (CocvidCases.getStatus() == 0) {
			countCured = + 1;
			return countCured;
		}
	}
	public double symptomsPercentage() {
		//vriskei to pososto emfanisis tou kathe symptom
		double perc[];
		for (int i=0; i<= User.symptomsList.length(); i++) {
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
	
	public void deathPercentage() {
		//vriskei to pososto twn nekrwn apo covid tis efarmogis mas
		double dperc = countDead / CovidCases.getPatientCounter() * 100;
		System.out.println(dperc + "% of our registered covid patients have passed away.");
	}
	
	public void curedPercentage() {
		//vriskei to pososto twn therapeumenwn apo covid tis efarmogis mas
		double cperc = countCured / CovidCases.getPatientCounter() * 100;
		System.out.println(cperc + "% of our registered covid patients have been cured.");
	}
	
	public void ageMortality() {
		//otan kaneis update sto status
		//kalei tin ageGroups gia tous nekrous tis efarmogis
		if (CovidCases.getStatus() == 1) {
			ageGroups(agd);
		}
	}
	
	public int[] ageGroups(int[] a) {
		//mallon tha prepei na kaleitai apo tin covidcases + na ftiatxei enas pinakas me to count twn atomwn kathe ilikiakis omadas
		//dimiourgei pinakes plithismou se kathe ilikiaki omada
		if (CovidCases.age >= 0 && CovidCases.age <= 19) {
			a[0] =+1;
		} else if (CovidCases.age >= 20 && CovidCases.age <= 39) {
			a[1] =+1;
		} else if (CovidCases.age >= 40 && CovidCases.age <= 59) {
			a[2] =+1;
		} else if (CovidCases.age >= 60 && CovidCases.age <= 79) {
			a[3] =+1;
		} else if (CovidCases.age >= 80) {
			a[4] =+1;
		}
		return a;
	}
	
	public double deathPercentage(int num) {
		//vriskei to pososto twn nekrwn apo covid tis efarmogis mas ana ilikiako group
		return double dperc_ag = countDead / CovidCases.ageGroups() * 100; //xreiazomaste edw ton pinaka pou tha ftiaxtei apo tin covidcases
		}
	
	public void deathsPerAge() {
		// kalei tin deathPercentage gia kathe ilikiako group kai ektypwnei tin thnisimotita tou
		for (int i=0; i <= 4; i++) {
			System.out.println(deathPercentage(agd[i]) + "% of this age group:" + agegroups[i] + "have passed away.");
		} 
	}
	
	public void printAgeAverage() {
		//typwnei ton meso oro ilikias twn asthenwn
		System.out.println(CovidCases.ageAverage() + "is the average age of our registered covid patients.");
	}
	
	public void printAgeAveragePerSymptom() {
		//typwnei ton meso oro ilikas twn asthenwn ana symptwma
		for (i=0;i <= User.symptomsList.length(); i++) {
		System.out.println(ageAveragePerSymptom.counter[i] + "is the average age of our registered covid patients who have experienced" + User.symptomsList[i]);
		}
	}
	
	
}
