package Threads.ThreadScheduling;

public class MainClass {
	 public static void main(String[] args) throws Exception 
	  {
	    ThreadDemo d1 = new ThreadDemo();
	    ThreadDemo d2 = new ThreadDemo();
	    //though u start the first thread first, as second thread
                   //has higher priority it is getting executed first	
	    System.out.println(" hi in the main class");
	    d1.setName("first");
	    d1.setPriority(Thread.MIN_PRIORITY+1);
	    d2.setName("second");
	    d2.setPriority(Thread.MAX_PRIORITY-1);
	   //s given like this wil not gaurantee the order 
	    d1.start();
	    d1.join();//the code below this line is executed only when  this d1 is finished with its job
	   
	    d2.start();
	    System.out.println("Over");
	    throw new Exception();
	  }

}

