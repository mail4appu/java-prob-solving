package Oops.overloading.sup;

/**
 * @author Test
 * 
 * If we observe clearly talk method is overloaded. Even though String type is sub type of Object type.
 * It is called over loading only. In method overloading, arguments must  change. So any change is arguments is overloading only.
 * 
 * Here the question is which method is called?
 * Ans: The most specific method is called.
 * 
 * For example: talk(null) prints, parent String is talking null
 * 
 * When method is overloaded with sub types, "most specific method"  is chosen by JVM
 *
 */
public class SuperClass {
	
	private void run(){
		System.out.println("Parent is running");
	}
	
	public void talk(Object lang){
		System.out.println("parent Object is talking: "+lang.toString());
	}
	
	public void talk(String lang){
		System.out.println("parent String is talking: "+lang.toString());
	}

}
