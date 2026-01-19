package Oops.constructor;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Test
 *  
 * Very good site for understanding Oop design principles:
    http://www.codeproject.com/Articles/93369/How-I-explained-OOD-to-my-wife
 *  
 *  
 *  
 */
public class Main {
	{
		System.out.println("abc");
	}
	public static void main(String[] args) {
		Main m= new Main();
		Child c= new Child(123);
		c.callMethod();
		Parent p= new Parent();
	   
	
	}

}
