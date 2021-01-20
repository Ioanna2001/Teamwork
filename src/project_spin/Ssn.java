package project_spin;

import java.util.ArrayList;
import java.util.HashMap;

class Ssn {
	protected static ArrayList<Integer> ssn = new ArrayList<Integer>();
	protected static HashMap<Integer, Boolean> checkedSsn = new HashMap<Integer, Boolean>();
	protected static int i;//indicates if the ArrayList is initialized

	protected static void ssnInitiator() {
		ssn.add(123456);
		checkedSsn.put(123456, false);
		ssn.add(789012);
		checkedSsn.put(789012, false);
		ssn.add(738910);
		checkedSsn.put(738910, false);
		ssn.add(739200);
		checkedSsn.put(739200, false);
		ssn.add(111222);
		checkedSsn.put(111222, false);
		ssn.add(222333);
		checkedSsn.put(222333, false);
		ssn.add(333444);
		checkedSsn.put(333444, false);
		ssn.add(555666);
		checkedSsn.put(555666, false);
		ssn.add(777888);
		checkedSsn.put(777888, false);
		ssn.add(999000);
		checkedSsn.put(999000, false);
		ssn.add(111111);
		checkedSsn.put(111111, false);
		ssn.add(222222);
		checkedSsn.put(222222, false);
		ssn.add(333333);
		checkedSsn.put(333333, false);
		ssn.add(444444);
		checkedSsn.put(444444, false);
		ssn.add(555555);
		checkedSsn.put(555555, false);
		ssn.add(777777);
		checkedSsn.put(777777, false);
		ssn.add(888888);
		checkedSsn.put(888888, false);
		ssn.add(999999);
		checkedSsn.put(999999, false);
		ssn.add(000000);
		checkedSsn.put(000000, false);
		i = 1;
	}

	protected static void addSsn(int ssn) {
		if(i == 0) {
			ssnInitiator();
		}
		Ssn.ssn.add(ssn);
		checkedSsn.put(ssn, false);
	}

	//tsekarei an yparxei to ssn sth bash dedomenwn
	protected static boolean checkSsn(int s) {
		for (int i:ssn) {
			if (i == s) {
				if (checkedSsn.get(s) == true) {
					return false;
				} else {
					checkedSsn.put(s, true);
					return true;
				}
			}
		}
		return false;
	}
}
