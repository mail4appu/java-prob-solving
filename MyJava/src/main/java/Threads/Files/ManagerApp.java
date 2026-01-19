package Threads.Files;

public class ManagerApp {
	public static void main(String[] args) throws InterruptedException {
		Thread t1= new Thread(new FileTask("First content"));
		t1.setName("FIRST");
		Thread t2= new Thread(new FileTask("Second content"));
		t1.setName("SECOND");
		t1.start();
		t1.join();
		t2.start();
	}

}
