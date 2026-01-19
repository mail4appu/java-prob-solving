package Threads.interrupts;

import java.util.Map;

public class AnotherTask implements Runnable {

    Map<String, MyCountDownLatch> statusManager;

    public AnotherTask(Map<String, MyCountDownLatch> statusManager) {
        this.statusManager = statusManager;
    }

    @Override
    public synchronized void run() {
        try {
            System.out.println("Waiting in Second Task");
            this.wait(4000);
            statusManager.get("Main").setAborted(true);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
