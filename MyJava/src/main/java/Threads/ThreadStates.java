package Threads;

import java.lang.management.ThreadInfo;

/**
 * @author Test
 * 
 *  New state, before starting
 *  Runnable after starting
 *  Blocked, when waiting for lock to enter into synchronized method or block or when deadlock occurs
 *  waiting, When thread calls wait() or join()
 *  
 *  sleep(long time) ..sleep can not wait for forever. bc it does not have constructor sleep()
 *  wait(long  time)
 *  join(long time).....above three result in timed waiting
 *
 */
public class ThreadStates {

	public static void main(String[] args) {
		Thread t= new Thread();
	    System.out.println("Before starting: "+t.getState());
	    t.start(); //Here we have not defined any run(). Here the default run() of Thread class is being executed
	    System.out.println("After starting: "+t.getState());
	    
	    try {
			Thread.sleep(10000);
			t.interrupt();
			System.out.println(t.getState());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("After interruption");
        
	}
}
