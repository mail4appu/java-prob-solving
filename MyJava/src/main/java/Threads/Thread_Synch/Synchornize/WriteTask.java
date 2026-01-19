package Threads.Thread_Synch.Synchornize;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteTask implements Runnable {
	private StringBuffer sb;
	private ReadWriteBuffer rwbuff;
	public WriteTask(ReadWriteBuffer rwbuff) {
		this.rwbuff=rwbuff;    	
	}

	public void run() {
		int i=0;
		// TODO Auto-generated method stub
		try {
			FileOutputStream fos= new FileOutputStream(new File("abc.txt"));
			while(i==0){
				sb=rwbuff.getSb();
				fos.write(sb.toString().getBytes());
				if(sb==null)
					break;
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
