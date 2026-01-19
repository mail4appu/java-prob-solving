package Threads.threadpool;

import java.util.Queue;

/**
 * @author evarapp
 * 
 * Worker is a thread or a machine performs two jobs
 * 1. takes task from queue
 * 2. performs that task
 * so each worker should know about the Queue first and then the task.
 * 
 * So each thread is locked on queue but not on the task
 * 
 * Wait()/notify() is the mechanism by which thread listens to another thread
 * 
 * taskQueue.wait()--i.e thread is registered to this queue, and any updates to this queue are notified by other threads
 * 
 * We can say worker is idle, when worker calls wait() or sleep()
 *
 */
public class Worker extends Thread{
	Queue<Runnable> taskQueue;
	public Worker(Queue<Runnable> queue) {
		taskQueue =queue;
	}

	@Override
	public void run() {
		//System.out.println("worker is about to start:  "+Thread.currentThread().getName());
		while (true) {
			synchronized (taskQueue) {
				while(this.taskQueue.isEmpty()){ //When queue is empty, make this thread wait on queue object, once queue is filled this thread will be notified
					try {
						taskQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				Task task = (Task) this.taskQueue.poll();
				try{
					//here we are calling job's run method directly. 
					task.run();
				}catch(RuntimeException ex){
					ex.printStackTrace();
				}

			}


		}
	}

}
