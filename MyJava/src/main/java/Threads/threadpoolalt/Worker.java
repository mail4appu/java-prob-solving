package Threads.threadpoolalt;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author evarapp
 * <p>
 * Worker is a thread or a machine performs two jobs
 * 1. takes task from queue
 * 2. performs that task
 * so each worker should know about the Queue first and then the task.
 * <p>
 * So each thread is locked on queue but not on the task
 * <p>
 * Wait()/notify() is the mechanism by which thread listens to another thread
 * <p>
 * taskQueue.wait()--i.e thread is registered to this queue, and any updates to this queue are notified by other threads
 * <p>
 * We can say worker is idle, when worker calls wait() or sleep()
 */
public class Worker extends Thread {
    CustomBlockingQueue<Runnable> taskQueue;

    public Worker(CustomBlockingQueue<Runnable> queue) {
        taskQueue = queue;
    }

    @Override
    public void run() {
        System.out.println("worker  " + Thread.currentThread().getName() + "is taking task from Queue");
        while (true) { //This is how thread takes continuously from queue
            Runnable task =  taskQueue.take();
            if (task != null)
                task.run();
        }

    }
}

