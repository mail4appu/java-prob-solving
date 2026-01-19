package Threads;

public class SynchronizedCounter_MainClass {
	public static void main(String []args){
	SynchronizedCounter sc=new SynchronizedCounter();
	SynchronizedCounter sc1=new SynchronizedCounter();
	
	sc.increment();
	sc1.decrement();
	System.out.println(""+sc.value());
	
	System.out.println(""+sc1.value());
	}
}
