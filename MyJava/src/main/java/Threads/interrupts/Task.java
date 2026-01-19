package Threads.interrupts;

import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {
    Map<String, MyCountDownLatch> statusManager;

    public Task(Map<String, MyCountDownLatch> statusManager) {
        this.statusManager = statusManager;
    }

    @Override
    public synchronized void run() {
         Thread t1= new Thread(new AnotherTask(statusManager));
         t1.start();
        try {
            System.out.println("Waiting in first Task");
            this.wait(2000);
            //statusManager.get("Main").countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
