package Threads.threadpoolalt;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


/**
 * @author evarapp
 * 
 * Thread pool is like some service.
 * Which initializes a queue and adds the tasks to queue, when a task is submitted to it
 * It also brings worker threads to active state
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
	CustomBlockingQueue<Runnable> taskQueue;
	
	public ThreadPool(int maxNoOfThreads) {
		taskQueue= new CustomBlockingQueue<>(10) ;
		System.out.println("created a queue and creating threads");
		for(int i=0;i<maxNoOfThreads;i++){
			Thread worker= new Worker(taskQueue);
			worker.start();
		}
		
	}
	public synchronized void submit(Runnable task){
			taskQueue.put(task);
	}


}
