package Threads.Thread_Synch.Synchornize;

public class SharedCountMain {
	
	public static void main(String[] args) {
		SharedCountJob job1=new SharedCountJob(0, 500000);
		Thread t1= new Thread(job1);
		t1.setName("THREAD-1");
		
		SharedCountJob job2=new SharedCountJob(500001, 1000001);
		Thread t2= new Thread(job2);
		t2.setName("THREAD-2");
		long start=System.currentTimeMillis();
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end=System.currentTimeMillis();
		System.out.println("time taken: with threads:  "+(end-start));
		
		for(int i=0;i<1000002;i++){
			System.out.println(i);
		}
		
		long end2=System.currentTimeMillis();
		System.out.println("time taken: without thrads : "+(end2-end));
	}

}
