package Threads.Thread_Synch.Files;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Test
 * Need to check this without synchronized keyword thoroughly
 *
 */
public class FileJob implements Runnable{
	BufferedReader br;

	public void run() {
		try {
            //without class loader and without "/", the path is always relative to the current package of the class
			br= new BufferedReader(new InputStreamReader(FileJob.class.getResourceAsStream("myfile.txt")));
			//System.out.println("File Accessed by"+Thread.currentThread().getName());
			String line="";
			synchronized (this) {
				while((line=br.readLine())!=null){
					System.out.println(line+"       "+Thread.currentThread().getName());		
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
