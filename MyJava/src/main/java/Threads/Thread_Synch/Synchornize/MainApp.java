package Threads.Thread_Synch.Synchornize;

/**
 * @author apparao
 * 
 * Here the job is divided between two workers
 * 
 * Synchronized block or method
 * 
 * its like some thread has acquired the lock of the object, whose variable or method is shared
 * 
 * i.e thread has acquired the lock and the locked the code from inside. So this locked code is not available for other threads unless
 * 
 * current thread releases the lock
 * 
 * ie. you entered a room and locked it from inside.
 * unless you release the lock, after coming out no one can get that lock.
 * 
 * Lock is released even if thread leaves synchronized method after completion or due to any Error or Exception.

    Read more: http://javarevisited.blogspot.com/2011/04/synchronization-in-java-synchronized.html#ixzz3bbiLUi7Z

 * As far as synchronized code is concerned, there wont be any parallel execution
 * 
 * 
 * Wait(), notify() notifyAll() are defined in object class
 * because, We dont call all these methods on Thread class
 * 
 * The min purpose of these methods is intercommunication between threads
 * 
 * When intercommmunication is required?i.e  When threads are accessing a shared resource
 * 
 * i.e in synchronization context
 * 
 * wait() method forces the Thread to release the lock*****
 * h
 * That means Thread must hold the lock to realse it.
 * 
 * 
 * So wait() must be called in the synchronized context only.
 * 
 * if we call it in non synchronized context we will get IllegalMonitorStateException
 * 
 * 
 * notify() and notifyAll()
 * 
 * When a thread calls either of the above methods, All the waiting threads will be removed from the
 * waiting que and they will rush for the object lock.
 * 
 * That is threads will be in the waiting queue only when one thread has acquired the lock.
 * i.e using the synchronized block or method.
 * 
 * Before calling notiy() or notifyAll() one thread should acquire the lock
 * 
 * in Non-synchronized context, non of the threads will be in the waiting queue.
 * so There is no point in calling above methods in non synchronized context.
 * 
 *  if we call, we will get IllegalMonitorStateException
 *  
 *  Read more at: http://www.xyzws.com/javafaq/why-wait-notify-notifyall-must-be-called-inside-a-synchronized-method-block/127
 *  
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 *
 */
public class MainApp {
	public static void main(String[] args) throws InterruptedException {
	
		//Here we are giving the same job to two threads( workers). I.e a job shared between two
		Job job= new Job();
		Thread t1= new Thread(job);
		System.out.println(t1.getState());
		t1.setName("first");
		Thread t2=new Thread(job);
		t2.setName("second");
		t1.start();
		t2.start();
		
		System.out.println(t1.getState());
		try {
			t1.join();
			//System.out.println(job.count);
			t2.join();
			//System.out.println(job.count);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//new MainApp().notify();
		System.out.println(job.count);
		//new MainApp().wait();
		
		
	}
	
    	

}
