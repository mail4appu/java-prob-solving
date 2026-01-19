package Timer;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {
	
	public static void main(String[] args) throws Exception{
	

		File edrLog= new File("C://logfile.txt");
		RandomAccessFile raf = new RandomAccessFile(edrLog, "r");
		System.out.println("initial file length:  "+raf.length());
		String line="";
		while((line = raf.readLine()) != null) {
			System.out.println(line);
		}
		raf.seek(raf.getFilePointer());
		System.out.println("file pointer is:  "+raf.getFilePointer());
		startTimer(raf);
	}
	

	private static void startTimer(final RandomAccessFile r){
		System.out.println("inside startTimer");
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				
				String str = null;
				try {
					while((str = r.readLine()) != null) {
						System.out.println("str is"+str);
					}
					System.out.println("file pointer inside timer"+r.getFilePointer());
					r.seek(r.getFilePointer());
				} catch (IOException e) {
					e.printStackTrace();
				}
				catch(Exception e){
					e.printStackTrace();
					
				}
			}
		}, 3000, 5000);
	}

}
