package Threads.Thread_Synch.database;

import java.util.ArrayList;
import java.util.List;

public class DatabaseMain {
public static void main(String[] args) {
	System.out.println("before starting");
	List<Thread> list= new ArrayList<Thread>();
	//DBSelectJob dbj= new DBSelectJob();
	DBInsertionJob dbj= new DBInsertionJob();
	long start= System.nanoTime();
	for(int i=0;i<4;i++){
		Thread t= new Thread(dbj);
		t.setName(""+i);
		list.add(t);
		t.start();
	}
	for(Thread t:list){
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	long end= System.nanoTime();
	System.out.println("time taken to finish the job: "+(end-start));
}

}
