package Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author vapparao
 * 
 * Scanner is slower than String.split, StringTokenizer
 * StringTokenizer is faster than String.split(), Scanner
 * StringTokenizer use is discouraged in the new code
 * 
 * Flexible way to parse a String (big strings with integers, dates and etc in one string) or a File
 *  with mixed data types is to user Scanner.
 *  
 *  Scanner is meant for parsing a file or String
 *  parsing is like not reading line by line or word by word
 *  its like when you come across some datatype read it...
 * 
 * We can user BufferedReader also to read files and get the values
 * 
 * 
 * 
 * 
 * 
 * How to check whether a String is integer, double, boolean, long or Date?
 * TIP: always parse method is the answer
 * Integer.parseInt("")
 * Double.paresDouble("");
 * SimpleDateFormat.parse("")
 * 
 * all these parse methods return respective values, if input is valid
 * else throw exception
 *
 */
public class ScannerCSV {
	public static void main(String[] args) {
		try {
			File f= new File("C:\\Users\\vapparao\\workspace\\SampleProject\\src\\tabDelimiter.txt");

			Scanner scan= new Scanner(f);
			

			List<String> values= new ArrayList<String>();
			while(scan.hasNext()){
				String temp= scan.next();
				if(temp.equals("20/03/83")){
					if(!isDate(temp)){
					values.add(temp);
					}
					continueToRead(scan, values);
					break;
				}

			}
			System.out.println("final list contains:  "+values);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public static void continueToRead(Scanner scan, List<String> values){
		while(scan.hasNext()){
			String temp= scan.next();
			if(!temp.equals("20/03/86")){
				if(!isDate(temp)){
					values.add(temp);
					}

			}
			else{
				break;
			}
		}
	}


	public static boolean isDate(String temp){
		boolean result=false;
		try{
			SimpleDateFormat dateFmt= new SimpleDateFormat("dd/mm/yy");
			dateFmt.parse(temp);// all parse methods take string as input and returns the respective values
			result=true;
		}catch(Exception ex){
			result= false;
		}
		return result;
	}
}
