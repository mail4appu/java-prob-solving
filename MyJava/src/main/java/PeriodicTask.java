import java.util.Timer;
import java.util.TimerTask;


public class PeriodicTask extends TimerTask{
	public void run() {
		String[] commandLine = { "explorer", "http://202.67.6.27/PresenzaSouth/Login.aspx" };
		try{
			System.out.println("hi");
			 
		}catch(Exception ex){
			
		}
		  
	}
	
	 public static void main(String [] args) throws Exception{
		TimerTask timerTask= new PeriodicTask();
		Timer timer= new Timer();
		timer.scheduleAtFixedRate(timerTask, 3000, 10000);
	    }

}
