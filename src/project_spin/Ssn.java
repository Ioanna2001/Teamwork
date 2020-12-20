package project_spin;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class Ssn {
	static private File file = new File("C:\\Users\\Ioanna\\Documents\\Git\\Teamwork\\src\\project_spin\\projectSsn");
	try {
		private static  FileOutputStream file_out = new FileOutputStream(file);
		private static  FileInputStream file_in = new FileInputStream(file);
		private static  DataInputStream input = new DataInputStream(file_in);
		private static  DataOutputStream output = new DataOutputStream(file_out); 
	}
	catch (Exception e) {
		System.err.println("Fine not found");
	}
	protected static void writeSsn(int ssn) {
		try {
			output.writeInt(ssn);
		} catch (Exception e) {
			System.err.println("Error in Data output (ssn)");
		}
	}

	protected static int readSsn(){
		try {
			return input.readInt();
		} catch (Exception e) {
			System.err.println("Error in Data input(ssn)");
		}
		finally {
			//an to arxeio den exei allo ssn epistrefei -1
			return -1;
		}
	}
}
