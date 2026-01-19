package Threads.sum;

public class SharedCountJob implements Runnable{
	
	int start;
	int end;
	
	public SharedCountJob(int start, int end) {
		this.start=start;
		this.end=end;
	}

	public  void run() {
		int count=0;
		for(int i=start;i<=end;i++){
			count=count+i;
			System.out.println(count);
			
		}
		
	}

}
