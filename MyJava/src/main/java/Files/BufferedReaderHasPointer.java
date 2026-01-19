package Files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author vapparao
 * 
 * Here BufferedReader reads based on the new line,
 * it keeps reading. It has also pointer i.e if it finishes two lines and if we give br to another method,
 * there it reads from the third line like scanner only.
 * 
 * BufferedReder comes with 8kb buffer. so it fills the buffer from bytes and moves the data or reads the data
 * 
 * Common Notation: anything with buffer is faster
 * 
 * 
 * NOTE: BufferedReader and Scanner can not get pointer/poisition where it reads
 * whereas RandomAccessFile gives the pointer. it has getPointer() method. This is extremely useful when we have to do some operations with 
 * earlier pointer or current pointer
 *
 */
public class BufferedReaderHasPointer {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("scan.txt"));
		String line="";
		while((line=br.readLine())!=null){
			if(line.contains("records in file")){
				continueToRead(br);
				
			}
		}
	}
	private static void continueToRead(BufferedReader br)throws Exception{
		
		String line="";
		while((line=br.readLine())!=null){
			System.out.println("line is:                  "+line);
			if(line.contains("records imported ")){
				System.out.println("line is:"+line);
			}
				
				
			}
		
	}
	

}