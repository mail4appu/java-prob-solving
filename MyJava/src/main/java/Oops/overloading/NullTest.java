package Oops.overloading;

/**
 * @author Test
 * 
 *  Here the overloading ambiguity occurs hence compile time error
 *
 */
public class NullTest {

	   public static void method(Object obj){
	     System.out.println("method with param type - Object");
	   }
	 
	   public static void method(String str){
	     System.out.println("method with param type - String");
	   }
	 
	   public static void method(StringBuffer strBuf){
	     System.out.println("method with param type - StringBuffer");
	   }
	 
	   public static void main(String [] args){
	    // method(null); //... compile-time error! because null is equally specific to String and StringBuffer
	   }
	}