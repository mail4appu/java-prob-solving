package Scanner;

import java.util.Scanner;

/**
 * @author apparao
 * 
 * BufferedReader is faster than Scanner.
 * Scanner is meant for parsing capabilites.
 * i.e When a file has differnet data types like ints, strings, doubles etc.
 * and we want to parse all ints or doubles. In that scenario use scanner
 *
 */
public class ScannerWithString {
	public static void main(String[] args) {
	Scanner scan= new Scanner("INFO     :                          (Step 1 of 8) Make sure IPICS database is in on-line mode");
	scan.useDelimiter("\\D+ of \\D+") ;
	while(scan.hasNextInt()){
		System.out.println(scan.nextInt());
	}
	}
	

}
