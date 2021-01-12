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
