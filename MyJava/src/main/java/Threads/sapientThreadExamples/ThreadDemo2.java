package Threads.sapientThreadExamples;

/**
 * @author apparao
 * 
 * Here each thread is locked on the same obeect.
 * 
 * We can visualize the passing object to Thread class as lock object
 *
 */
public class ThreadDemo2 {
	private int count=1;
	public synchronized void doSomeThing(){
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"\t"+count++);
		}
	}
	public static void main(String[] args) {
		ThreadDemo2 demo= new ThreadDemo2();
		Thread t1= new Example(demo);
		Thread t2= new Example(demo);
		t1.start();
		t2.start();
	}

}
class Example extends Thread{
	ThreadDemo2 demo;
	public Example(ThreadDemo2 d){
		demo=d;
	}
	public void run(){
		demo.doSomeThing();
	}
}