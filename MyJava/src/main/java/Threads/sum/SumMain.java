package Threads.sum;

public class SumMain {

	public static void main(String[] args) {
		SumOfNumbers son=new SumOfNumbers(0,100000);
		Thread t1= new Thread(son);
		SumOfNumbers sons=new SumOfNumbers(100000, 200000);
		Thread t2= new Thread(sons);
		t1.start();
		t2.start();
	}
}
