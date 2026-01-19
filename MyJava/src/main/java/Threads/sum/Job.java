package Threads.sum;


/**
 * @author evarapp
 * 
 * 
 * if the job instance is given to multiple threads, then "only run method is local to each thread".
 * Any instance variables accessed in run method are common to all the threads which act on the same job instance or which do the same copies of job.
 * 
 * But if different job instance is given to each thread(worker/machine), than each job instance( That implements runnable) is local to each thread. Nothing is common or shared between different threads
 * I.e All the data inside object  is local to that specific thread . 
 * 
 * In a single core processor, if there are multiple threads, processor switches the context among multiple threads based on the cpu time slice.
 * i.e like two machines,  power is given by cpu to one machine at a time and excutes till cpu time slice is done and switches the same power to other thread once cpu time slice is done.
 * 
 * 
 * In a multi core processor, each thread can run on single core or two threads in single core. ( where hyper threading is enabled)
 * 
 * #nproc is the command to know the no of processors on linux or lscpu
 * 
 * 
 * ThreadLocal is thread specific, this is useful when a single job instance is given to multiple threads and each thread wants to have its own data, then ThreadLocal comes for rescue.
 * Its scope is Thread specific like request and session scopes in web.
 * 
 * ThreadLocal to set thread state...
 * 
 * 
 * How thread join works:
 * http://javabypatel.blogspot.in/2016/05/how-thread-join-method-works-internally-iava.html
 * 
 * 
 * 
 * 
 *
 */
public class Job implements Runnable{
	private int count;
    private Object lock1 = new Object();
    
    private Object lock2= new Object();
    String str= new String();
    public static ThreadLocal<Integer> threadLocal= new ThreadLocal<Integer>();
    
	public void run() {
		   threadLocal.set((int)(Math.random()*100D));
			for(int i=0;i<10000;i++){
				//System.out.println(j);
				increment(i);
				
			
		}
			//count=count+1;
			System.out.println("********"+Thread.currentThread().getName()+":  "+threadLocal.get());

	}
	public void increment(int i){
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			System.out.println(Thread.currentThread().getName()+"  :  "+i+" :"+threadLocal.get());
			
			
			
	}
	public int getCount() {
		return count;
	}
}
