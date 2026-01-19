package Threads.scheduledthreadpool;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.*;

public class Task implements Runnable {
    ScheduledExecutorService scheduledExecutorService;
    CountDownLatch countDownLatch= new CountDownLatch(4);
    MainApp mainApp;

    public Task(ScheduledExecutorService scheduledExecutorService, MainApp mainApp) {
        this.scheduledExecutorService= scheduledExecutorService;
        this.mainApp= mainApp;
    }

    @Override
    public void run() {

        System.out.println("running the PING task");
        try {
            InetAddress inetAddress = InetAddress.getByName("49.37.169.147");
            if (inetAddress.isReachable(15)) {
                System.out.println("reachable");
                mainApp.printResponse("success");
            }
            else{
                while(countDownLatch.getCount()!=0) {
                     countDownLatch.countDown();
                     scheduledExecutorService.schedule(this, 0, TimeUnit.SECONDS);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mainApp.printResponse("failure");

    }
}
