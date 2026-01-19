package Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FlattenTime {
	public static void main(String [] args)
	 {
	String filename = "D:/time.txt";
	String abc="appu";
	 if(args.length > 0)
	    {
	      filename = args[0];
	   }
	   PersistentTime time = new PersistentTime();
	    FileOutputStream fos = null;
	    ObjectOutputStream out = null;
	     try
	    {
	      fos = new FileOutputStream(filename);
	      out = new ObjectOutputStream(fos);
	      out.writeObject(abc);
	       out.close();
	     }
	     catch(IOException ex)
	    {
	      ex.printStackTrace();
	     }
	   }
}
