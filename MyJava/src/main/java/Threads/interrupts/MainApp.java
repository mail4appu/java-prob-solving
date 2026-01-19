package Threads.interrupts;

import java.util.HashMap;
import java.util.Map;

public class MainApp {
    public static void main(String[] args) {
        Map<String, MyCountDownLatch> statusManager=new HashMap<>();
        statusManager.put("Main", new MyCountDownLatch(1));
        Thread t= new Thread(new Task(statusManager));
        t.start();
        try {
            MyCountDownLatch myLatch = statusManager.get("Main");

                statusManager.get("Main").await();
                System.out.println("Dependent threads finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
