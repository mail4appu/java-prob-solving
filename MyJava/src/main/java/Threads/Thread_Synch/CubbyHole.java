package Threads.Thread_Synch;

public class CubbyHole {
	   private int contents; 
	   private boolean available = false; 

	   public synchronized int get() {
		   return contents;
	   }
	   

	   public synchronized void put(int value){
		   this.contents=value;
	   }
	
}
