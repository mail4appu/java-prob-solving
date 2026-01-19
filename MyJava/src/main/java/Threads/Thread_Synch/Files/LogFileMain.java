package Threads.Thread_Synch.Files;

import java.util.ArrayList;
import java.util.List;

public class LogFileMain {
	public static void main(String[] args) {
		List<Thread> list= new ArrayList<Thread>();
		LogFileJob lfj= new LogFileJob();
		Thread t=null;
		long start= System.currentTimeMillis();
		for(int i=0;i<4;i++){
			t= new Thread(lfj);
			t.setName(""+i);
			list.add(t);
			t.start();
		}
		for(Thread thread: list){
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long end=System.currentTimeMillis();
		System.out.println("time taken*********: "+(end-start));
	}


}
