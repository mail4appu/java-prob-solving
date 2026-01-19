package FileIO.Comparision;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

public class BufReaderNBufInputStrm {

	public static void main(String[] args) throws Exception{
		File f = new File("C://Users//SESA439295//Downloads//Resume.docx");
		//System.out.println(SizeFetcher.getObjectSize(f));

		/*long bufRdrTime=new BufReaderNBufInputStrm().getTimeByBufferedReader(f);
		long BufInputStrmTime=new BufReaderNBufInputStrm().getTimeByBufferedInputStream(f);
		System.out.println("time taken bufferedReader is: "+bufRdrTime+"  and by BufferedInputStream is:    "+BufInputStrmTime);*/
	}


	public long getTimeByBufferedReader(File f) throws Exception{
		long strt=0;
		long end=0;
		BufferedReader br=null;
		try{

			br= new BufferedReader(new FileReader(f));
			String line="";
			strt=System.currentTimeMillis();
			System.out.println("strt time is"+strt);
			while((line=br.readLine())!=null){
				//System.out.println(""+line);
				
			}
			end=System.currentTimeMillis();
			System.out.println("end time is"+end);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			br.close();
		}


		return end-strt;
	}

	public long getTimeByBufferedInputStream(File f) throws Exception{
		long strt=0;
		long end=0;
		BufferedInputStream bis=null;

		try{

			bis= new BufferedInputStream(new FileInputStream(f));
			int ch=0;
			strt=System.currentTimeMillis();
			System.out.println("start time is"+strt);
			while((ch=bis.read())!=-1){
				//System.out.println(""+ch);
				
			}
			end=System.currentTimeMillis();
			System.out.println("end time is"+end);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			bis.close();
		}



		return end-strt;
	}


}
