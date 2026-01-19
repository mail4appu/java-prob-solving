package Threads.threadpoolalt;

import java.util.LinkedList;
import java.util.Queue;

public class CustomBlockingQueue<Runnable> {

    Queue<Runnable> taskQueue = new LinkedList();
    int maxSize=0;

    public CustomBlockingQueue(int capacity) {
        maxSize=capacity;
    }

    public synchronized void put(Runnable runnable) {
        while (taskQueue.size()==maxSize) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        taskQueue.add(runnable);
        this.notifyAll();
    }

    public synchronized Runnable take() {
        try {
            while(taskQueue.isEmpty()) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Runnable task = taskQueue.poll();
        this.notifyAll();
        return task;
    }

}
