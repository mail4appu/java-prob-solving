package Threads.producerconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenOddNumbers {
    public static void main(String[] args) {

        Object lock= new Object();

        ExecutorService service= Executors.newFixedThreadPool(2);

        Runnable oddNumberTask=()->{
            synchronized (lock) {
                for (int i = 1; i <=20; i++) {
                    System.out.println("Odd--"+i);
                    try {
                        i = i + 1;
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //System.out.println("Odd released and waiting");

                }
            }
        };

        Runnable evenNumberTask= ()-> {
            synchronized (lock) {

                for (int i = 2; i <= 20; i++) {
                    System.out.println("Even--"+i);
                        i++;
                        lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // System.out.println("Even released and waiting");
                }
            }

        };

        service.submit(oddNumberTask);
        service.submit(evenNumberTask);



    }


}
