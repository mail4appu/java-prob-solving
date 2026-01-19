package Threads.threadpool;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


/**
 * @author evarapp
 * 
 * Thread pool is like some service.
 * Which contains a queue and adds the tasks to queue, when a task is submitted to it
 * 
 * Operations on shared variables are locked but not the shared variables.
 * 
 * Adding tasks and removing tasks are locked up here, because is Queue is shared across thread pool and threads in the pool.
 * 
 * Thread pool is like a thread group which forms other threads(workers) and creates a queue
 * 
 *
 */
public class ThreadPool {
	Queue<Runnable> taskQueue;
	
	public ThreadPool(int maxNoOfThreads) {
		taskQueue= new ArrayBlockingQueue<Runnable>(10) ;
		//System.out.println("created a queue");
		for(int i=0;i<maxNoOfThreads;i++){
			Thread worker= new Worker(taskQueue);
			worker.start();
		}
		
	}
	public  void submit(Runnable task){
		synchronized (taskQueue) {
			taskQueue.add(task);
			//Adding each task and notifying the workers which are waiting on taskQueue. 
			taskQueue.notifyAll();
		}
		//System.out.println("Added the task to queue and notified all threads");

	}


}
