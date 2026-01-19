package Threads.States;

public class ThreadJob implements Runnable{

	public void run() {
		
		try {
			System.out.println("worker thread is sleeping");
			Thread.sleep(10000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
