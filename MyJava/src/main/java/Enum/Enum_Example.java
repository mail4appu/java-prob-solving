package Enum;

import java.text.DecimalFormat;



/**
 * @author Test
 * 
 * the first and most important reason being is type safety of enums
ie. you can not assign any value other than enum type to an enum
i.e during compile time itself, compiler can detect errors with enums
Non type safety is not the issue with constants, Issue with constants is different
*****With constants compile time errors can not be avoided where as the same can be avoided with enums, because enums are type safe
With constants we get runtime errors if something is wrong. Where as with enums  same errors occur at compile time, rather than at run time.
Fixing compile time errors is easy than fixing run time errors
 *
 *
 *   Example to understand better: 
 *   http://www.journaldev.com/716/java-enum-examples-with-benefits-and-class-usage
 *   
 *   We can feel the difference when we pass enum or constant to a method and apply some business logic.
 *   
 *   Passing the constant or enum to a method is the point where we can find the significant difference. The above link illustrates the same
 *   
 *   Examples with enum and other uses:
 *   
 *   http://crunchify.com/why-and-for-what-should-i-use-enum-java-enum-examples/
 *   
 *
 */
public class Enum_Example {
	
	/**
	 * @param args
	 */
	public static void main(String args[])  
	  { 
	    Apple ap;
	    System.out.println("Here are all Apple constants");
	    System.out.println(Apple.A.toString()+" ****** "+Apple.A.name()+ "   *****   "+Apple.D.getPrice()+ " *** "+Apple.valueOf("A"));

	    Apple allapples[] = Apple.values(); 
	    for(Apple a : allapples) 
	      System.out.println(a.getPrice());
	 
	    System.out.println(); 
	    
	    ap = Apple.valueOf("F");
	    
	    System.out.println("ap contains " + ap.getPrice());
        double d = 1.24;
        DecimalFormat df = new DecimalFormat("#.####");
        System.out.print(df.format(d));

	 
	  } 
}
