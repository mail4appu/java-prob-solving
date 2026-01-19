package Threads.ThreadScheduling;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

public class CompletableScheduler {
    CountDownLatch countDownLatch= new CountDownLatch(4);


    public static void main(String[] args) {
        CompletableScheduler completableScheduler= new CompletableScheduler();
        completableScheduler.delegateLongRunningTassk(completableScheduler);


    }

    public String printResponse(String result) {
        System.out.println(result);
        return result;
    }

    private void delegateLongRunningTassk(CompletableScheduler completableScheduler){
        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(5);
        PingTask pingTask= new PingTask(completableScheduler, scheduledExecutorService);
        scheduledExecutorService.schedule(pingTask, 0, TimeUnit.SECONDS);
    }


}
