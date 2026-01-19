package Threads.Asynchronous;

public class TaskOne implements Runnable {
	int count=10;
	long timeSleep=1000;
	public void run() {
		try {
			Thread.sleep(this.timeSleep);
			int sum = 0;
			for (int i = 1; i <= this.count; i++) {
				sum = sum + i;
			}
			System.out.println( " thread has sum = " + sum +
					" and is going to sleep for " + timeSleep);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Finished Task");

	}

}
