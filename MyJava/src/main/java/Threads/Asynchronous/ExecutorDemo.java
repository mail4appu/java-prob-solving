package Threads.Asynchronous;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class
ExecutorDemo {
public static void main(String[] args) throws InterruptedException, ExecutionException {
	
	ExecutorService service = Executors.newFixedThreadPool(2);
	service.submit(new TaskOne());
	System.out.println("in the end of main thread");
	service.shutdown();
}

}
