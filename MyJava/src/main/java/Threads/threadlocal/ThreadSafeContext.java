package Threads.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class ThreadSafeContext {
    public static ThreadLocal<Map<String, Integer>> threadMetadata= new ThreadLocal<Map<String, Integer>>(){
         @Override
         protected Map<String, Integer> initialValue() {
             return new HashMap<>();
         }

         @Override
         public Map<String, Integer> get() {
             return super.get();
         }
     };
}
