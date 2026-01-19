package Files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class ReadCommaSeparatedValue {

	public static void main(String args[]) {
		String eachline = "";
		int linenumber=0;
		int tokennumber=0;
		
		try {
			FileReader fr = new FileReader(
					"C:\\Users\\vapparao\\workspace\\SampleProject\\src\\tabDelimiter.txt");
			BufferedReader br = new BufferedReader(fr);

			while ((eachline = br.readLine()) != null) {
				if(eachline.startsWith("20/03/83")|| eachline.startsWith("20/03/85")){
				StringTokenizer st = new StringTokenizer(eachline, ",");/*-----\t is for tab delimited files*/
				System.out.println("line number is"+(++linenumber));
				while (st.hasMoreTokens()) {
					tokennumber++;
					System.out.println("each value from the csv file is: "
							+ st.nextToken());

				}
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("total no of line in the file :  "+linenumber+"\nNo of tokens file has:   "+tokennumber);
	}
}
