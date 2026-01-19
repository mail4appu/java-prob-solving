package Threads.Thread_Synch;

public class Job implements Runnable{
	private int count;
    private Object lock1 = new Object();
    private Object lock2= new Object();
    String str= new String();
	public void run() {
		int j=10;
		for(int i=0;i<10000;i++){
			//System.out.println(j);
			increment();
			
			
		}

	}
	public void increment(){
		synchronized (new String()) {
			++count;
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			System.out.println(Thread.currentThread().getName()+"  :  "+count);
			
			
		}
	}
	public int getCount() {
		return count;
	}

}
