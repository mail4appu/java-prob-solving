package Threads.callback;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CallbackMain {
    AtomicInteger atomicInteger= new AtomicInteger();
    public static void main(String[] args) throws InterruptedException, ExecutionException {




    }

    public  void checkStatus(String threadName){
        System.out.println("child thread  "+threadName+" finished its job ");
    }
}
