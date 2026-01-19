package Threads.sum;

public class SumOfNumbers implements Runnable{
	private int end;
	private int start;
	public SumOfNumbers(int start, int end) {
		this.end=end;
		this.start=start;
	}
	public void run() {
		int sum=0;
		for(int i=start;i<end;i++){
			//sum=sum+i;
			System.out.println(Thread.currentThread().getName()+":  "+i);

		}
		System.out.println("final sum is: "+sum);
	}

}
