package Threads.Thread_Synch;

public class Producer extends Thread{
	private CubbyHole cubbyhole;  
	   public Producer(CubbyHole c) { 
	      cubbyhole = c; 
	         } 
	   public void run() { 
	      for (int i = 0; i < 100; i++) { 
	         cubbyhole.put(10+i); 
	         System.out.println("value in producer"+i);
	        /* try { 
	           // sleep((int)(Math.random() * 100)); 
	         } catch (InterruptedException e) { } */
	      } 
	   } 

}
