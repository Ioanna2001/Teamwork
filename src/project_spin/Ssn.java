package project_spin;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

class Ssn {
	/*
	 * protected static ArrayList<Integer> ssnInitiator(ArrayList<Integer> ssn) {
	 * 	ssn.put(123456);
	 * ssn.put(789012);
	 * ssn.put(738910);
	 * ssn.put(739200);
	 * ssn.put(111222);
	 * ssn.put(222333);
	 * ssn.put(333444);
	 * ssn.put(555666);
	 * ssn.put(777888);
	 * ssn.put(999000);
	 * ssn.put(111111);
	 * ssn.put(222222);
	 * ssn.put(3333330;
	 * ssn.put(444444);
	 * ssn.put(555555);
	 * ssn.put(777777);
	 * ssn.put(888888);
	 * ssn.put(999999);
	 * ssn.put(000000);
	 * return ssn;
	 * }
	 */
	static private File f = new File("https://github.com/Ioanna2001/Teamwork/tree/main/src/project_spin/projectSsn//");
//eisagwgh ssn sto arxeio
	protected static void writeSsn(int ssn) {
		DataOutputStream output;
		try {
			if (String.valueOf(ssn).length() == 6) {
				output = new DataOutputStream(new FileOutputStream(f));
				output.writeInt(ssn);
				output.close();
			} else {
				System.out.println("Invalid SSN");
			}
		} catch (IOException e1) {
			System.err.println("Error in data output method: writeSsn");
		}
	}
//anagnwsh ssn apo arxeio
	protected static int readSsn(){
		try {
			DataInputStream input = new DataInputStream(new FileInputStream(f));
			int x = input.readInt();
			input.close();
			return x;
		} catch (Exception e) {
			System.err.println("Error in data input method: readSsn");
		}
		finally {
			//an to arxeio den exei allo ssn epistrefei -1
			return -1;
		}
	}
//ananewnei th lista ssn
	protected static void updateSsn() {
		try {
			DataInputStream input = new DataInputStream(new FileInputStream(f));
			int x = input.read();
			int count = 0;
			while (x != -1) {
			count ++;
			x = input.read();
			}
			if (count == CovidCases.ssn.size()) {
				for (int j = 0; j < count; j++){
					x = input.readInt();
					for (int i:CovidCases.ssn) {
						if (i != x) {
							CovidCases.addSsn(x);
						}
					}
				}
			}
		} catch (IOException e) {
			System.err.println("Error in method updateSsn");
		}
	}
}
