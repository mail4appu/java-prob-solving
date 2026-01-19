package Threads.callbacks;

import Threads.ThreadA;

import javax.swing.plaf.metal.MetalBorders;
import java.util.concurrent.CompletableFuture;

public class MainApp  {
    public static void main(String[] args) {
        WorkerJob workerJob = new WorkerJob(()-> System.out.println("I am call back method:   "+Thread.currentThread().getName()));
        Thread t = new Thread(workerJob);
        t.start();
        System.out.println("Main thread is finished   "+Thread.currentThread().getName());

        CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("supply async   "+Thread.currentThread().getName());
            return 1;
        }).thenApply(i-> {

            System.out.println("apply " + Thread.currentThread().getName());
            return i + 1;
        }).thenAccept(i->{
            System.out.println("Accept   "+ Thread.currentThread().getName());
        });


    }


}
