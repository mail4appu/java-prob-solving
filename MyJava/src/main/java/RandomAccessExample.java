import java.io.RandomAccessFile;


public class RandomAccessExample {
public static void main(String[] args) throws Exception{
	RandomAccessFile raf= new RandomAccessFile("bacd\nadfadadff", "rw");
	System.out.println(""+raf.length());
	
}
}
