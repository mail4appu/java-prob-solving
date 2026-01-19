package Threads.scheduledthreadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainApp {
    ScheduledExecutorService scheduledExecutorService=null;

    public static void main(String[] args) {
        MainApp mainApp= new MainApp();
        mainApp.scheduledExecutorService= Executors.newScheduledThreadPool(5);

        Task task=new Task(mainApp.scheduledExecutorService, mainApp);
        mainApp.scheduledExecutorService.schedule(task, 0, TimeUnit.SECONDS);



    }
    public void printResponse(String result){
        System.out.println("Received response"+result);
    }


}
