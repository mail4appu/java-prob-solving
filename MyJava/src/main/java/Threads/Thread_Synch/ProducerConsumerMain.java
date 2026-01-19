package Threads.Thread_Synch;

public class ProducerConsumerMain {
	
	public static void main(String args[])throws Exception{
		long start=System.nanoTime();
		CubbyHole ch= new CubbyHole();
		Producer p= new Producer(ch);
		Consumer c= new Consumer(ch);
		p.start();
		c.start();
		long end=System.nanoTime();
		System.out.println("total time: "+(end-start));
		
	}
	

}


