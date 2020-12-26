package project_spin;

import java.util.Arrays;
import java.util.Collections;

public static class Who {

	int countDead; //posoi nekroi
	int countCured; //posoi therapeumenoi
	int agd[]; // age group dead
	String agegroups[] = {"0-19", "20-39", "40-59", "60-79", "80+"};
	
	public void printPatientCount () {
		//ektipwnei ola ta krousmata tis efarmogis
		System.out.println("The number of covid patients registered in our application are:");
		System.out.println(getPatientCounter());
	}
	
	public void sufficinetSample() {
		//pou tha to kaloume??
		//elegxei kai proeidopoiei an ta krousmata tis efarmogis mas einai liga
		// etsi vste na einai aksiopista ta statistika
		if (getPatientCounter() < 1000) {
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
		if (getStatus() == 1) {
			countDead =+ 1;
			return countDead;
		}
	}
	
	public int curedCount() {
		//metraei osous exoun therapeutei apo covid
		if (getStatus() == 0) {
			countCured =+1;
			return countCured;
		}
	}
	
	public void frequentSymptoms() {
		//vriskei to pio sixno simptoma pou eixan ta krousmata tis efarmogis mas
		 int max = Collections.max(Arrays.asList(symptoms_counter()));
		 System.out.println("The most frequent symptom(s) is/are:")
		 for (int i=0; i <= symptomsList.length(); i++) {
			 if (max = symptoms_counter(i)) {
				 System.out.println(symptomsList(i));
			 }
		 }
	}
	
	public void symptomsPercentage() {
		//vriskei to pososto emfanisis tou kathe symptom
		double perc;
		for (int i=0; i<= symptomsList.length(); i++) {
			perc = symptoms_counter(i) / getPatientCounter() * 100; 
			System.out.println(perc + " % of our registered patients have experienced" + symptomsList(i));
		}
	}
	
	public void deathPercentage() {
		//vriskei to pososto twn nekrwn apo covid tis efarmogis mas
		double dperc = countDead / getPatientCounter() * 100;
		System.out.println(dperc + "% of our registered covid patients have passed away.");
	}
	
	public void curedPercentage() {
		//vriskei to pososto twn therapeumenwn apo covid tis efarmogis mas
		double cperc = countCured / getPatientCounter() * 100;
		System.out.println(cperc + "% of our registered covid patients have been cured.");
	}
	
	public void ageMortality() {
		//otan kaneis update sto status
		//kalei tin ageGroups gia tous nekrous tis efarmogis
		if (getStatus() ==1) {
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
		return double dperc_ag = countDead / ageGroups() * 100; //xreiazomaste edw ton pinaka pou tha ftiaxtei apo tin covidcases
		}
	
	public void deathsPerAge() {
		// kalei tin deathPercentage gia kathe ilikiako group kai ektypwnei tin thnisimotita tou
		for (int i=0; i<=4; i++) {
			System.out.println(deathPercentage(agd[i]) + "% of this age group:" + agegroups[i] + "have passed away.");
		} 
	}
}
