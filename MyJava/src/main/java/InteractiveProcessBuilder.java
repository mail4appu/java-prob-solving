import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;


public class InteractiveProcessBuilder {
	public static void main(String[] args) {
       try{
		ProcessBuilder pb= new ProcessBuilder();
		
		pb.command("/opt/cisco/ipics/bin/setup_monit_alerts");
		Process p=pb.start();
		pb.redirectErrorStream(true);
		BufferedReader br= new BufferedReader(new InputStreamReader(p.getInputStream()));
		OutputStream os=p.getOutputStream();
		String input="localhost"+"\n";
		os.write(input.getBytes());
		os.flush();
		 String line="";
		while((line=br.readLine())!=null){
			System.out.println("hiiiiiiii");
			if(line.contains("Password")){
				
			}
		}
		os.close();
		p.waitFor();
		p.destroy();

       }catch(Exception ex){
    	   ex.printStackTrace();
       }
	}

}
