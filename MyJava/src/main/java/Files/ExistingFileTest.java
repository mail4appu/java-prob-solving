package Files;

import java.io.File;

public class ExistingFileTest {
	public static void main(String[] args)  {
		try{
		//This is how we represent existing file on machine
		File f = new File("C://Users//vapparao//UCCX//IPICS//000C29C6B506.lic");
		File f1 = new File("C://Users//vapparao//UCCX//IPICS//abc.txt");
		//f1.createNewFile();
		System.out.println("File size is"+f.length());
		System.out.println("File1 size is"+f1.length());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}
