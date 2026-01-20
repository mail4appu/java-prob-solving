package com.ericsson.file.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUploadJob implements Runnable {
	String filePath;
	InputStream fis;
	UploadStatus upldStatus;
	int status;

	public FileUploadJob(String filePath, InputStream fis) {
		this.filePath=filePath;
		this.fis=fis;
	}

	public void run() {
		OutputStream outpuStream = null;
		upldStatus= new UploadStatus();
		try {
			System.out.println("inside back ground thread");
			int read = 0;
			//create a buffer
			byte[] buffer = new byte[10*1024];
			File f= new File(filePath);
			//if file does not exist 
			if(!f.exists()){
				outpuStream = new FileOutputStream(f);
				//Efficient way of reading and writing. Here we are not reading each byte or write each byte. We are reading 1024 bytes and wrting the same

				upldStatus.setFileName(filePath);
				int count=0;
				while ((read = fis.read(buffer)) != -1) {
					System.out.println("count value:  "+count);
					
					count++;
					outpuStream.write(buffer, 0, read);
					upldStatus.updateUploadProgress(count*5);
					
				}
				outpuStream.flush();
			}
			//outpuStream.close();
		} catch(IOException iox){
			System.out.println("IOException occurred**********");
			iox.printStackTrace();
		} /* catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	*/		
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally {
			if(outpuStream != null && fis!=null){
				try{
					outpuStream.close();
					fis.close();
				} catch(Exception ex){

					ex.printStackTrace();
				}
			}
		}
	}
}
