package Threads.sum;
public class CountWithoutThreads {
	public static void main(String[] args) {
		long start=System.currentTimeMillis();
		int count=0;
		for(int i=0;i<40002;i++){
			count=count+i;
			System.out.println(count);
		}
		
		long end=System.currentTimeMillis();
		System.out.println("time taken: without thrads : "+(end-start));
		
	}
}
