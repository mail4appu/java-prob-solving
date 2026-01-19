package Threads.callbacks;

public class WorkerJob implements Runnable{
    CallBackInterface callBackInterface;

    WorkerJob(CallBackInterface callBackInterface){
        this.callBackInterface=callBackInterface;
    }
    @Override
    public void run() {
        System.out.println("I am Worker and working on =====:  "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        callBackInterface.callMeBack();
    }
}
