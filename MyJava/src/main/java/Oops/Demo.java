package Oops;

public class Demo {
	 public  static void show( )//remove static
	  {
	    System.out.println("Hello");
	  }
	  public static void display( )//static method cant make a reference to nonstatic method
	  {
	   System.out.println(" in the abc");
	   show( );
	  } 
	  
	  
}
