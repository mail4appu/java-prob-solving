package Threads.Thread_Synch.Files;


public class FileAccessWithThreads {
	public static void main(String[] args) {
    FileJob fj= new FileJob();
    Thread t1= new Thread(fj);
    t1.setName("first");
    Thread t2= new Thread(fj);
    t2.setName("second");
    t1.start();
    t2.start();
	}	

}
