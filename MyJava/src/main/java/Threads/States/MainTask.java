package Threads.States;

/**
 * @author Test
 * 
 *  The main class/Servlet that creates thread instances is like a manager which has some sub-ordinates working under it.
 *  
 *   MainClass/Servlet===Manager
 *   Thread instances/workers===Sub-ordinates
 * 
 * When a manager can start a worker, he can interrupt the worker too.
 * 
 * i.e Thread has to be started by some one and should be interrupted by someone too.
 * 
 * ie. main thread calls t1.start() to start and t1.interrupt() to interrupt the same thread
 * 
 * Interrupt means--quit what you are doing currently. Sleeping and waiting threads can be interrupted
 * 
 * wait()--Context switch happens, must release the lock, hence must be called in synchronized context. Will be in WAITING state indefinitely until another thread calls notify() or notify all() method
 * wait(1000)--Context switch happens, must relase the lock, hence must be called in synchronized context. Will be in TIMED_WAITING state. once time out, tries to acquire the released lock. Hence will be in the blocked state
 * sleep(1000)==> Context switch happens, can be called anywhere. will be in TIMED_WAITING state. once the time out is done, can be in RUNNABLE state or TERMINATED if nothing is to be done
 * 
 * after interrupting a timed waiting/waiting thread, it can be either in the RUNNABLE state(if some statements are left in the run method) or in the TERMINATED state if nothing is left
 * 
 * BLOCKED state is also called as MONITOR state
 * 
 * BLOCKED state is the state where a thread waits for another thread to release the lock,  it is waiting on
 * 
 * This happens during synchronized block or synchronized method execution. We can visualize this more when there are only two threads.
 * Run CountMainApp.java program on terminal and look at the visual vm. We can figure this out 
 * 
 * 
 * Running program on terminal
 * 
 *  go to the directory which is before the package
 *  export classpath=.
 *  java packagename.classname 
 * 
 * 
 * 
 * A thread can go into BLOCKED state only in synchronized context. No synchronized context, no BLOCKED state
 * 
 * After timed waiting via wait(timeout) method, a thread tries to acquire the lock, if it does not get the lock will be in BLOCKED state. Enters the running state once lock is released 
 * 
 * if cpu time slice is done before releasing the lock, ie. the context switch happened before releasing the lock, then  current thread will be in WAITING state
 * 
 * Thread.sleep(1000), object.wait()/wait(timeout)..Both cause context switch to happen. I.e cpu is released and cpu performs some other task
 * 
 * Generally context switch happens once the cpu time slice runs out. Above are the other ways of achieving this.
 * 
 * After Thread.sleep(Timeout) of certain time out, Context switches back to the thread only if cpu is available ******
 * 
 * 
 * Understanding interruption in java
 * http://www.javatpoint.com/interrupting-a-thread
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
 *
 */
public class MainTask {
	public static void main(String[] args) {
     Task task= new Task();
     task.setUrl("http://www.javatpoint.com/interrupting-a-thread");
     Thread worker= new Thread(task);
     worker.setName("Employee");
     Thread.currentThread().setName("Manager");
     worker.start();
     try {
     Thread.sleep(1000);
     System.out.println(worker.getState());
     worker.interrupt();
	//	worker.join(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println("main task completed"); 
     
		
		
	}
}
