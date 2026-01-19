package Threads.sapientThreadExamples;

/**
 * @author apparao
 * 
 * Possible outputs for this class can be
 *   Thread-1	 is active
     Thread-0	 is active
     Thread-0	 is active sec
     Thread-1	 is active sec
     
 * 
 *   Thread-0	 is active
     Thread-1	 is active
     Thread-0	 is active sec
     Thread-1	 is active sec
   
   
 * 
 *
 *   Thread-1	 is active
     Thread-1	 is active sec
     Thread-0	 is active
     Thread-0	 is active sec
 *
 *
 * Explaining the output:
 *  Here each thread is getting different job instance.
 *  i.e synchronized method is not locked on same object. It is locked on different object****
 *  
 *  A) thread-1 is active, cpu time slice runs out
 *     thred-0 is active and cpu time slice exists till it finishes its execution
 *     thread-1 gets cpu time slice
 *     
 *  B) easily understood
 *  
 *  C) Thread 1 becomes active and cpu time slice exists till it finishes
 *     Thread-0 gets cpu time slice
 * 
 *
 *
 */
public class ThreadDemo1 implements Runnable{
	static Boolean A1=true;
	static Boolean A2=true;
	public static void main(String[] args) {
		try{
			Thread tobj1= new Thread(new ThreadDemo1());
			tobj1.start();
			Thread tobj2= new Thread(new ThreadDemo1());
			tobj2.start();
		}catch(Exception e){
           System.out.println(e);	
		}

		


	}
	public synchronized void run() {
     for(int i=0;i<1;i++){
    	 if(A1){
    		 System.out.println(Thread.currentThread().getName()+"\t is active");
    		 A1=false;
    		 A2=true;
    	 }
    	 if(A2){
    		 System.out.println(Thread.currentThread().getName()+"\t is active sec");
    		 A2=false;
    		 A1=true;
    	 }
    	/* try{
    		 Thread.sleep(100);
    	 }catch(Exception e){
    		 System.out.println(e);
    	 }*/
     }
	}
}
