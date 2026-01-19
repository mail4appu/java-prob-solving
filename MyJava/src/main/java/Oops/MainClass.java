package Oops;

/**
 * @author vapparao
 * 
 * Abstraction says what a class does. i.e its methods
 * Encapsulation: Every class has encapsulation if it implements Data hiding and implementation hiding concepts
 * Genreally Encapsulation=keeping a wapper around something
 * In every class, the calss is wrapped around its feilds and methods
 * i.e class members and 
 *
 */
public class MainClass extends Demo{
	
	public static void main(String []args){
		Demo demo=new Demo();//Static methods are inherited but cant be overridden instead of redefine the same 
		demo.show();
		MainClass mc=new MainClass();
		mc.show();
		String s="hello";
		StringBuffer sb=new StringBuffer("bye");
		//System.out.println("value of x is"+new SuperClass(-5));
	
	
	}
	
	
}
