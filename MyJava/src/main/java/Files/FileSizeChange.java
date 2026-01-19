package Files;

import java.io.File;

/**
 * @author vapparao
 *
 *
 *letus suppose file is updated dynamically example log file
 *then the file reference f1 always points to updated file
 *
 *
 */
public class FileSizeChange {
	public static void main(String[] args) throws Exception{
		File f1 = new File("C://Users//vapparao//UCCX//IPICS//abc.txt");
		System.out.println("size of file"+f1.length()); //suppose 100
		//while waiting add some more content to this file.
		Thread.sleep(20000);
		//Now chek the file size
		System.out.println("Size fo the file next:"+f1.length());// file size changes some 200 if file updated with new content in the backend
		                                                         // imagine its like we are writing the file using outpustream.write and then accessing it
		//i.e f1 always ponints to updated file
	}

}
