package Threads.Thread_Synch.Synchornize;


/**
 * @author apparao
 * 
 * Threads can be used widely when the job is very huge or long and can be divided into multiple **independent** tasks**** 
 * 
 * In real world, this class is a job object which is given to 
 * worker(i.e thread)
 * 
 * Thread is the worker and Run method is the job of the worker. As the method can not stay outside
 * a class, we must define the method ( ie. run()) inside  a class. Hence job is the class which has defined the run method.
 * Example: 
 * Its like, our objective is to increment a variable 20000 times.
 * 
 * and this job is divided between two workers( two threads) by 10000 increments(run method) for each worker
 * 
 * Explanation:
 * 
 * Without context switch there is no concept of multi threading.
 * 
 * Even in synchronized context, context switch should happen. i.e when context is switched to other thread,
 * 
 * as the lock is not released by the first thread, the other thread has to wait till the time first thread has finished the synchronized code
 * (in between there might be many context switches between the two threads)
 * 
 * 
 * Imagine like this:
 * 
 * When two threads are started, two workers are doing their job in parallel
 * 
 * Each thread is run in its own stack.
 * 
 * 
 * Thread1        Thread2     
 *    |                |
 *    |                |
 *    |                |
 *  |------|       |------|
 *  |run() |       | run()|
 *  
 *  Here run method code is copy of original code for every thread. As every thread runs its job in its own stack*******
 *  
 *  But while executing synchronized code, every thread needs to acquire the lock present on object on which the code is synchronized
 *  
 *  Synchronization can be done on any lock.
 *  
 *  but when we give synchronized(new Object), we would get unexpected results.
 *  
 *  because, as the this code is copy for both the threads, new Object() is created twice.
 *  
 *  so every thread has its own lock for its own object. This is the case of multiple threads have multiple locks
 *  
 *  Hence we get unexpected results. Every thread's job is independent from other thread.
 *  
 *  
 *  How to get class level lock? synchronized("classname".class)
 *  
 *  Static method can be synchronized and thread needs to acquire class level lock for synchronized static methods or blocks
 *  
 *  public static void increment(){
 *         synchronized(Job.class){====> class level lock
 *             ++count()
 *         }
 *         }
 *  
 *  
 *  That is the reason when we define
 *  
 *  
 *  Thread1 after executing some statements in run method or executing the run method for some time(cpu time slice), Processor shifts the execution to second thread
 *  After Thread2 executes some statements in its run method or executing the run method for some time, processor shifts back the execution to Thread1
 *  Then Thread1 again starts its execution from the point or from the statement  where the context switch has happened inside its own run method.
 *          
 *    
 *  Synchronized==> acquire the lock of ****object***** where the shared resource(variable/method) is declared/defined. i.e the object of the class
 *  where the shared variable or shared method is defined.
 *  
 *  Synchronization is meant for thread safety
 *  
 *    
 *  Accessing the worker names and properties inside the run method
 *  Thread.currentThread().getName()*********
 *  Thread.currentThread().getState()****
 * 
 * Inside synchronized block or method, lock is released only when block or method execution is finished or when wait() method is called
 * 
 *
 *
 * understanding is:
 * 
 * Before cpu time slice  a thread might  acquire the same lock no of times and release the same equal no of times.
 * And before releasing the lock, thread might run out of cpu time slice. In this case, other threads try to enter the synchronized block but the lock is held by another thread.
 * 
 * i.e Thread can be in the queue or waiting state, even after acquiring the lock because cpu time slice is done before thread has released the lock.
 * 
 * So thread that acquired the lock waits for its next turn so that it executes the remaining statements and releases the lock.
 * 
 *
 *
 *
 */
public class CountJob implements Runnable{
	int count=0;
	static String name;

	public void run() {
		name=Thread.currentThread().getName();
		for(int i=0;i<800000;i++){
			name=Thread.currentThread().getName();
			increment();
		}
		//System.out.println("count value inside run : "+count);
		//System.out.println(Thread.getAllStackTraces());
	}

	/**
	 * Remove this synchronized and see the result
	 */
	public void increment(){
		//synchronized (this) {
			/*try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			//++count;
			try {
				System.out.println(Thread.currentThread().getName()+" is sleeping");
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" : "+(++count) );
			/*try {
				Thread.yield();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		
	//}

}
