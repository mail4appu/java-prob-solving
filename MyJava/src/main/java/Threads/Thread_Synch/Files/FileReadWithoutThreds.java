package Threads.Thread_Synch.Files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileReadWithoutThreds {
    public static void main(String[] args) {
    	try {
    		long start= System.currentTimeMillis();
			RandomAccessFile raf= new RandomAccessFile("/home/Test/workspace/MyJava/src/main/java/Threads/Thread_Synch/Files/myfile.txt", "r");
			String line="";
			int count=0;
			while((line=raf.readLine())!=null){
				count++;
			}
			long end=System.currentTimeMillis();
			System.out.println("count is: "+(end-start));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
