package Log;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class HAProgress {
	private int progressPercent;

	public String getProgress(String filePointer){

		String filePtr=filePointer;
		String finalMessage="";
		try{
			File edrLog= new File("haconfig.log");
			RandomAccessFile raf = new RandomAccessFile(edrLog, "r");
			long fileLengthOnReq=raf.length();
			//System.out.println("==================file lenght at the time of request: ================================= "+fileLengthOnReq+ "    file Pointer is:   "+ filePtr);
			long currentFilePtr=0;
			//System.out.println("initial file size: "+raf.length());
			String line="";
			String percentage="0";

			if(!filePtr.equals("0") && fileLengthOnReq>Long.parseLong(filePtr)){
				//System.out.println(" file  seek at: "+filePtr);
				raf.seek(Long.parseLong(filePtr));
				while((line = raf.readLine()) != null) {
					percentage=""+checkPercentage(line);	
					//System.out.println("percent in while"+percentage);
					currentFilePtr=raf.getFilePointer();
					//System.out.println("current file Pointer is: "+currentFilePtr);
					if(currentFilePtr>fileLengthOnReq)
						break;
				}
				filePtr=""+currentFilePtr;
				//System.out.println("file lenght at the time of time of leaving while:  "+filePtr);
			}

			//System.out.println("file length at the time of response  "+raf.length());
			if(filePtr.equals("0")){
				filePtr=""+fileLengthOnReq;

			}
			//System.out.println("next File Pointer is "+filePtr);
			finalMessage=percentage+"%"+filePtr;
			//System.out.println("final message contains: "+finalMessage);

			//response.getWriter().write(finalMessage);
			//startTimer(raf);

		}catch(Exception ex){
			ex.printStackTrace();
		}

		return finalMessage;
	}


	public  int checkPercentage(String line){
		boolean check=true;
		for(int i=1;i<=5;i++){
			if(line.contains(("CONFIG   "+i+"/5"))){
				System.out.println("i value is:  "+i);
				progressPercent= progressPercent+3;
				check=false;
			}

		}
		if(check){
			checkSubSteps( line);
			check=false;
		}
		if(line.contains("HA CONFIG PROCESS FINISHED WITH")){
			System.out.println("inside with 0 error");
			progressPercent=progressPercent+6;
		}
		else if(line.contains("Restarting IPICS services")){
			progressPercent=progressPercent+4;
		}
		else if(line.contains("IPICS services restarted")){
			System.out.println("restarted");
			progressPercent= progressPercent+6;
		}
		return progressPercent;

	}

	public void checkSubSteps(String line){
		//System.out.println("percentage forwarded: "+progPercent);
		if(line.contains("Step")){
			//Scanner scan= new Scanner(line);
			//scan.useDelimiter("\\D+");
			//int step=scan.nextInt();
			//System.out.println("step is: "+step);
			progressPercent=progressPercent+3;
		}
	}
}
