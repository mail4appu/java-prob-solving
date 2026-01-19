package Threads.sapientThreadExamples;

/**
 * @author apparao
 * 
 * 
 *  Some times output is as follows:
 *      POLO-2  0
        POLO-1  0
        POLO-2  1
        POLO-1  1
        POLO-2  2
        POLO-1  2
        POLO-2  3
        POLO-1  3
        POLO-1  4
        POLO-2  4

 * 
 * 
 * http://vanillajava.blogspot.in/2011/09/why-thread-priority-rarely-matters.html
 * 
 * Thread priority is only a hint to OS task scheduler. Task scheduler will only try to allocate more resources to a thread with higher priority, however there are no explicit guarantees.

   In fact, it is not only relevant to Java or JVM. Most non-real time OS use thread priorities (managed or unmanaged) only in a suggestive manner. 

   Thread priority does not guarantee execution order. It comes into play when resources are limited. If the System is running into constraints due to memory or CPU, then the higher priority threads will run first. 
   Assuming that you have sufficient system resources (which I would assume so for a simple program and the system resources you posted), then you will not have any system constraints
 *
 */
public class SapientExample implements Runnable {
	public static void main(String[] args) throws InterruptedException {
		Thread tobj1= new Thread(new SapientExample());
		tobj1.setName("POLO-1");
		tobj1.setPriority(10);
		tobj1.start();
		new SapientExample().start();

		Thread tobj2= new Thread(new SapientExample());
		tobj2.setName("POLO-2");
		tobj2.setPriority(1);
		tobj2.start();
		
		
	}

	public void start(){
		System.out.println("inside void");
	}
	public void run() {
      for(int i=0;i<5;i++){
    	  System.out.println(Thread.currentThread().getName()+"  "+i);
    	  try{
    		  Thread.sleep(5000);	
    	  }catch(Exception ex){
    		  System.out.println(ex);
    	  }
      }
	}

}
