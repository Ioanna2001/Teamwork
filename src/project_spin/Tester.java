package project_spin;

import java.util.*;

public class Tester {	

	//attributes
	static String[] symptomsList;

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		makeSymptomsList();
		System.out.println("Do you have any symptoms of the following?");
		for (int i = 0; i < 13; i++) {
			System.out.println(i + ". " + symptomsList[i]); //emfanizei ta symptwmata apo ton pinaka
		}
		System.out.println("Please write the symptoms' code numbers separated by blank spaces\n" + 
		"If you you don't have any symptoms press 0");
		String answer = sc.nextLine();
		String [] parts = answer.split(" "); //pairnei ksexwrista ta symptom codes
		boolean wrongAnswer = wrongAnswer(answer, parts);
		if (wrongAnswer) {
			System.out.println("wrong");
		} else {
			System.out.println("right");
		}
		

	}

	public static void makeSymptomsList() {

		symptomsList = new String[13];
		symptomsList[0] = "Fever";
		symptomsList[1] = "Dry cough";
		symptomsList[2] = "Tiredness";
		symptomsList[3] = "Aches and pains";
		symptomsList[4] = "Sore throat";
		symptomsList[5] = "Diarrhoea";
		symptomsList[6] = "Conjuctivitis";
		symptomsList[7] = "Headache";
		symptomsList[8] = "Loss of taste or smell";
		symptomsList[9] = "A rash on skin, or discolouration of fingers or toes";
		symptomsList[10] = "Difficulty breathing or shortness of breath";
		symptomsList[11] = "Cheast pain or pressure";
		symptomsList[12] = "Loss of speech or movement";

	}

	private static boolean wrongAnswer(String s, String [] p) {

		boolean wrong = (s.contains("0") && (p.length > 1)); //tsek an exei 0 enw den einai to mono stoixeio
	    int len = s.length();
	    for (int i = 0; i < len; i++) {

	    	if ((Character.isLetter(s.charAt(i)))) {
	            wrong = true; //tsek an exei grammata h apanthsh
	        }

	    }
	    return wrong;
	}

}
