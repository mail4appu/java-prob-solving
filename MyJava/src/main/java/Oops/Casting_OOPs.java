package Oops;

import Oops.inheritance.SubClass;
import Oops.inheritance.SuperClass;

/**
 * @author vapparao
 * OOPS concepts are only three
 * Encapsulation
 * Inheritance
 * Polymoriphism
 * (EIP like VIP)
 *
 */
public class Casting_OOPs {
	public static void main(String []args){
		SuperClass supclas=new SubClass(); //this is implicit casting. 
		                                   //Subcalss always fits in super class
		SubClass sub= (SubClass)supclas; //This is Explicit casting
		SubClass sc=new SubClass(123);//Implicit casting should be done before doing Explicit casting   
	    sc.show();
	    sc.show(10);
	    String s1= new String("appu");
	    String s2= new String("appu");
	    System.out.println("hashcode 1"+s1.hashCode());
	    System.out.println("hashcode 2"+s2.hashCode());
	    System.out.println("status:   "+s1.equals(s2));
	
	}

}
