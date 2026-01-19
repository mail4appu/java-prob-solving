package Threads.Thread_Synch.Synchornize;

public class SharedCountJob implements Runnable{
	
	int start;
	int end;
	
	public SharedCountJob(int start, int end) {
		this.start=start;
		this.end=end;
	}

	public  void run() {
		int count=start;
		for(int i=start;i<=end;i++){
			//count=count+1;
			System.out.println("Count vlaue:  "+i+"   :  "+Thread.currentThread().getName());
			
		}
		
	}

}
