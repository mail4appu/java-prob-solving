public class ThreadTestApp {
public static void main(String[] args)  {


    for(int i=0;i<20;i++){
        Thread t= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getId()+" is sleeping");
                    Thread.sleep(5*60*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

    }

}

}
