package Oops.overloading.main;

import Oops.overloading.sub.SubClass;
import Oops.overloading.sup.SuperClass;

/**
 * @author Test
 * Overloading does not need inheritance. Can be done in same class or subclass
 * 
 * Method overloading: method name should be same
 * Change in Data type of parameters( Even if it is sub-type, it is called as change in data type)
 *     or
 * Change in Number of parameters
 *     or
 * Change in Sequence of parameters            ---(D-N-S) of parameters—is overloading
 * Overloading in generally done in same class like String.valueOf(int), String.valueOf(double) etc.
 * 
 *  ************ Object type is given preference than reference type ***************
 * 
 * subString(int start, int end); subString(in start) are overloaded methods
 *
 *
 * Return type must not change in overloading
 *
 */
public class SuperSubMain {
	public static void main(String[] args) {
      SuperClass sup= new SubClass();
      sup.talk("English");
      String str= new String();
      sup.talk(null);
      
     
	}
}
