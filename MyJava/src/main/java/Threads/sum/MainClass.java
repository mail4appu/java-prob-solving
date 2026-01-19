package Threads.sum;

public class MainClass {
	  public static void main(String[] args) {
		  
	    Thread thread = new Thread(new MyThread());
	    /*thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
	      public void uncaughtException(Thread t, Throwable e) {
	        System.out.println(t + " threw exception: " + e);
	      }
	    });*/
	    thread.start();
	  }
	}

	class MyThread implements Runnable {
	  public void run() {
	    throw new ArithmeticException();
	  }

	}
	           
	         
