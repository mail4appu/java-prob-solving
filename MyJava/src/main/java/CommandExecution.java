import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class CommandExecution {
	public static void main(String args[])throws Exception{
		//String location= "C:\\WINDOWS\\Media";
		String command[]=new String[2];
		command[0]="C:\\Program Files\\Mozilla Firefox\\firefox.exe";
		command[1]="www.gmail.com";
		Runtime.getRuntime().exec(command);
		
		
		/*System.out.println("before");
		String line="";
		//process.waitFor();
		BufferedReader br= new BufferedReader(new InputStreamReader(process.getInputStream()));
		while((line= br.readLine())!=null){
		
		*///System.out.println("line is"+line);
		}
		
	

}
