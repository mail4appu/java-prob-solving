package Threads.ThreadScheduling;


import javax.swing.plaf.IconUIResource;
import java.net.InetAddress;
import java.util.concurrent.*;

public class Scheduler {

    CountDownLatch countDownLatch= new CountDownLatch(4);
    ScheduledExecutorService scheduledExecutorService=null;
    boolean runRequired=true;
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Scheduler scheduler= new Scheduler();
        scheduler.scheduledExecutorService = Executors.newScheduledThreadPool(5);
        Callable<String> task = () -> {
            InetAddress inetAddress = InetAddress.getByName("49.37.169.147");
            System.out.println("running the PING task");
            if (inetAddress.isReachable(0)) {
                System.out.println("reachable");
                return "reachable";
            }
            else{
                return "nonreachable";
            }


        };

        while (scheduler.countDownLatch.getCount()!=0){
            System.out.println("in while");
            long startTime=System.currentTimeMillis();
            ScheduledFuture<String> resultFuture = scheduler.scheduledExecutorService.schedule(task, 0, TimeUnit.SECONDS);
            String s = resultFuture.get(15, TimeUnit.SECONDS);

            if(s.equals("nonreachable")){
                scheduler.countDownLatch.countDown();
                resultFuture= scheduler.scheduledExecutorService.schedule(task, 0, TimeUnit.SECONDS);
            }
            String result = resultFuture.get(15, TimeUnit.SECONDS);
            long timeSpent=System.currentTimeMillis()-startTime;
            System.out.println("result value     :   "+result);
            if(result.equals("reachable")){
                System.out.println("received response");
                break;


            }
            System.out.println("#########: "+scheduler.countDownLatch.getCount());
            scheduler.countDownLatch.countDown();
            if (resultFuture.isDone() == false) {
                resultFuture.cancel(false);
            }
            System.out.println(resultFuture.isDone());

    }

    }



}
