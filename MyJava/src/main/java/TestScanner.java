import java.io.File;
import java.util.Scanner;


public class TestScanner {
	public static void main(String[] args) throws Exception{
		File f= new File("C:\\Users\\vapparao\\workspace\\SampleProject\\scan.txt");
		Scanner scan= new Scanner(f);
	
		while(scan.hasNext()){
			if(scan.next().contains("records imported"))
			System.out.println(scan.next());
			//continueToRead(scan);
			//}
		}
	}
	public static void continueToRead(Scanner scan){
		while(scan.hasNextLine()){
		System.out.println(scan.nextLine());
		}
	}

}
