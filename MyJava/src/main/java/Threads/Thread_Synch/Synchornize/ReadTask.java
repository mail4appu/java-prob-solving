package Threads.Thread_Synch.Synchornize;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadTask implements Runnable{
	
	public ReadWriteBuffer rwbuff;
	
	public ReadTask(ReadWriteBuffer rwbuff) {
		this.rwbuff=rwbuff;
		// TODO Auto-generated constructor stub
	}

	public void run() {
		// TODO Auto-generated method stub

		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/home/apparao/workspace/MyJava/src/messages_en.properties"))));
			String line="";
			StringBuffer sb= new StringBuffer();
			while((line=br.readLine())!=null){
				rwbuff.setSb(sb.append(line));

			} 

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
