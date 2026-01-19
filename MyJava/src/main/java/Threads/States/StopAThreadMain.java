package Threads.States;

public class StopAThreadMain {
	
	public static void main(String[] args) {
		ThreadJob job= new ThreadJob();
		Thread t= new Thread(job);
		t.start();
		try {
			System.out.println("Main thread is sleepging");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main thread is interrupting worker thread to stop its job");
		t.interrupt();
		Thread.currentThread().interrupt();
	}

}
