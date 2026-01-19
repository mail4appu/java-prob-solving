package FileIO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReadMain {
	public static void main(String[] args) {
		File f= new File("C:\\Users\\vapparao\\Desktop\\file.txt");
		
		int ch=0;
		int i=1;
		try {
			FileInputStream fis= new FileInputStream(f);
			BufferedInputStream bis= new BufferedInputStream(fis, 4*1024);
			while((ch=bis.read())!=-1){
				System.out.println("in read:  "+i);
				i=i+1;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
