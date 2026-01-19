package Threads.ThreadScheduling;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PingTask implements Runnable {

    ScheduledExecutorService scheduledExecutorService;
    CompletableScheduler completableScheduler;

    public PingTask(CompletableScheduler completableScheduler, ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService=scheduledExecutorService;
        this.completableScheduler=completableScheduler;
    }

    @Override
    public void run()  {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getByName("49.37.169.147");
            System.out.println("running the PING task");
            if (inetAddress.isReachable(0)) {
                completableScheduler.printResponse("Reachable");
            }
            else{
                scheduledExecutorService.schedule(this, 15, TimeUnit.SECONDS);
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
