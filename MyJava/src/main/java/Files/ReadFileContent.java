package Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFileContent {
	public static void main(String[] args) throws Exception{
		File f= new File("C://Users//vapparao//UCCX//IPICS//000C29C6B506.lic");
		BufferedReader br= new BufferedReader(new FileReader(f));
		String line="";
		while((line=br.readLine())!=null){
			System.out.println(line);
		}
			
		
	}
	

}
