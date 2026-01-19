package Threads.Thread_Synch.Files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Test
 *
 */
public class LogFileJob implements Runnable{
	BufferedReader br;
	//RandomAccessFile raf;
	int noOfThreads=5;
	public void run() {
		//br= new BufferedReader(new InputStreamReader(FileJob.class.getResourceAsStream("myfile.txt")));
		long start= System.currentTimeMillis();
		try {
			RandomAccessFile raf= new RandomAccessFile("/home/Test/workspace/MyJava/src/main/java/Threads/Thread_Synch/Files/myfile.txt", "r");
			//System.out.println(raf.length());
			long length=raf.length()/4;
			//System.out.println("each threads job size "+length);
			int threadId=Integer.parseInt(Thread.currentThread().getName());
			raf.seek(threadId*length);
			System.out.println("Thread "+ threadId+"   is at "+raf.getFilePointer());
			String line="";
			int count=0;
			while((line=raf.readLine())!=null){
			
				count++;
				
				if(raf.getFilePointer()-1==((threadId+1)*length)){
					
					break;
					
				}
				
			}
			
			System.out.println("Time taken by: "+Thread.currentThread().getName()+"  is:  "+(System.currentTimeMillis()-start)+"   count is: "+Thread.currentThread().getStackTrace());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}


}
;