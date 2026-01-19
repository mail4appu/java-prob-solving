package Threads.sum;

public class JobMain {
	public static void main(String[] args) {
		Job job= new Job();
		Thread t1=new Thread(job);
		t1.setName("first worker");
		Thread t2= new Thread(job);
		t2.setName("second worker");
		t1.start();
	
		t2.start();
		try {
			t1.join();
			
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("final count value :  "+job.getCount());
		
		
	}
}

