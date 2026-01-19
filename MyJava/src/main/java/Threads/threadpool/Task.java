package Threads.threadpool;

public class Task implements Runnable{
	private int start, end;


	public Task(int start, int end) {
		this.start=start;
		this.end=end;
	}

	public void run() {
		System.out.println(" \n Prime Numbers in range [" + this.start + "-"
				+ this.end + "]");
		while (start <= end) {
			if (isPrime(start)) {
				System.out.print(" " + start);
			}
			start++;
		}

	}

	private boolean isPrime(int n)
	{
		// Corner case
		if (n <= 1)
			return false;

		// Check from 2 to n-1
		for (int i = 2; i < n; i++)
			if (n % i == 0)
				return false;

		return true;
	}

}
