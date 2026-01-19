package Threads.sum;

/**
 * @author evarapp
 * 
 * We may not the see the difference in time taken because here everything is done in the memory.
 * No thread has to do anything out of memory.
 *
 */
public class SharedCountMain {
	
	public static void main(String[] args) {
		SharedCountJob job1=new SharedCountJob(0, 20000);
		Thread t1= new Thread(job1);
		t1.setName("THREAD-1");
		
		SharedCountJob job2=new SharedCountJob(20001, 40001);
		Thread t2= new Thread(job2);
		t2.setName("THREAD-2");
		//long start=System.currentTimeMillis();
		
		t1.start();
		t2.start();
		long start=System.currentTimeMillis();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end=System.currentTimeMillis();
		System.out.println("time taken: with threads:  "+(end-start));
		
		
	}

}
