package Threads.threadlocal;

import java.util.Map;

public class ThreadLocalApp {
    public static void main(String[] args) {

        new Thread(()->{
            Map<String, Integer> localMap = new ThreadLocalApp().applyNameNpriority("first", 10);
            System.out.println(localMap.keySet());

        }).start();


        new Thread(()->{
            Map<String, Integer> localMap = new ThreadLocalApp().applyNameNpriority("Second", 20);
            System.out.println(localMap.keySet());
        }).start();
    }

    private   Map<String, Integer> applyNameNpriority(String name, int priority){
        Map<String, Integer> threadMetadata = ThreadSafeContext.threadMetadata.get();
        threadMetadata.put(name, priority);

        return threadMetadata;


    }
}
