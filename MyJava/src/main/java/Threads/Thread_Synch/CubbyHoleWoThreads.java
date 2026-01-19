package Threads.Thread_Synch;

public class CubbyHoleWoThreads {
	static int contents;
public static void main(String[] args) {
	long start= System.nanoTime();
	for(int i=0;i<100;i++){
    contents=i;
    System.out.println("Consumer: "+i);
    
}
	for(int i=0;i<100;i++){
	    contents=i;
	    System.out.println("produces: "+(i+10));
	    
	}
	long end=System.nanoTime();
	System.out.println("total time is"+(end-start));
}
}
