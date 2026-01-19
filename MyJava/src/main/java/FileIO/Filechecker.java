package FileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Filechecker {
	public static void main(String[] args)  {
		try{
		//This is how we represent existing file on machine
		File f = new File("C://Users//vapparao//UCCX//IPICS//000C29C6B5061.lic");
		//FileInputStream fis= new FileInputStream("C://Users//vapparao//UCCX//IPICS//000C29C6B5061.lic");
		//FileOutputStream fos= new FileOutputStream("C://Users//vapparao//UCCX//IPICS//000C29C6B5061.lic");
		File f1 = new File("C://Users//vapparao//UCCX//IPICS//abc.txt");
		//f1.createNewFile();
		System.out.println("File existance: "+f.exists());
		System.out.println("File1 size is: "+f1.length());
		//System.out.println("File inputstream "+fis.read());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}
