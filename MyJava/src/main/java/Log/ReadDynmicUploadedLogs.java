package Log;


import java.io.RandomAccessFile;
import java.util.Timer;
import java.util.TimerTask;

public class ReadDynmicUploadedLogs  extends TimerTask{
	String filePointer="0";
	static int percentage=0;
	static String resp="0";

	public void run() {
		try{
			
			//System.out.println("before triggering request");
			HAProgress ha=new HAProgress();
			resp=ha.getProgress(filePointer);
			System.out.println("response is: "+resp);
			String[] respArray=resp.split("%");
			filePointer=respArray[1];
			percentage=(Integer.parseInt(respArray[0])+percentage);
			System.out.println("final:  "+percentage);

		}catch(Exception ex){
			ex.printStackTrace();
		}



	}
	public static void main(String[] args) throws Exception{
		TimerTask timerTask= new ReadDynmicUploadedLogs();

		Timer timer= new Timer();
		timer.scheduleAtFixedRate(timerTask, 3000, 10000);
		

	}



}

