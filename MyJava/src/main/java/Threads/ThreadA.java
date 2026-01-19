package Threads;

/**
 * @author 173518
 *
 */
public class ThreadA {
	
		public static void main(String []args)throws InterruptedException
		{
		ThreadB b =new ThreadB();
		
		b.start();
		synchronized(b)//object gets the  lock.........use this inplace of b and see
		{
		System.out.println("iam calling wait method");
		b.wait();
		System.out.println("I got notification");
		}
		System.out.println(b.total);
		}
}
