package Oops.inheritance;

/**
 * @author apparao
 * In over riding: Return type should be same or small(if it is refernce type) but can  not be big
 * 
 * Return type : Should be same for primitives and can be smaller  for reference types but can not be bigger type
 * 
 * Static methods can not be overridden. Over riding is a concept related to Objects. In case of defining the same static method in child class too, 
 * Then it is called method hiding.
 * 
 * Static methods are bonded based on the type(reference type) not by object 
 * 
 *  Object a= new MyObject();
 *  Here a is reference type and MyObject is Object
 *  
 *  Static methods are bonded by reference type not by Object. Just as overloaded methods are bonded by type not by object
 *
 *
 */
public class Child extends Parent{
	Child display(int i){ // Because of above theory, compilation fails
		System.out.println("child overridden display");
		return null;
	}
	static void test(){
		System.out.println("child test");
	}
	public static void main(String args[]){
		Parent p= new Child();
		p.display(5);
		p.test(); //Because of the above static theory, parent static method is called but not child static method.
	}
}
