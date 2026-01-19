package Oops.Overriding.sup;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SuperClass {
	
	public static void run(){
		System.out.println("Parent is running");
	}
	
	public void talk(Object lang)  throws IOException{
		System.out.println("parent is talking: "+lang.toString());
	}

}
