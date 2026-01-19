package Threads;

public class ThreadB extends Thread{
	int total=0;
	public void run()
	{
	synchronized (this)//.thread got lock of ThreadB object. bc the shared variable total is present it ThreadB
	{
	System.out.println(" Thread starting calculation");
	for(int i=0;i<=10000;i++)
	{
		total=total+i;
	}
	System.out.println("Thread giving notification call"+total);
	//notify();//thread releases lock again
	}
	}
}
