package Threads.Files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Callable;

public class FileTask implements Runnable{
	
	File file = new File("/home/apparao/workspace/MyJava/src/main/java/Threads/Files/threadfile.txt");
	private String content;
	public FileTask(String content) {
		this.content=content;
	}

	public void  run()  {
		// TODO Auto-generated method stub
		//synchronized (this) {
			
		
		
		try {

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(Thread.currentThread().getName()+" is writing: ############\n");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i=0;i<10000;i++){
				bw.write(content+"\n");
			}
			
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
		//}
		
		
		return ;
	}
	
	

}
