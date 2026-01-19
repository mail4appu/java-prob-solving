package Oops.Overriding.sub;

import java.io.FileNotFoundException;
import java.io.IOException;

import Oops.Overriding.sup.SuperClass;

/**
 * @author Test
 * 
 * Private method bears and dies in the same class. 
 * 
 * It can not be invoked/called or available anywhere else other the class which creates it
 *
 * Overriding happens only in subclass.
 * only methods can be overridden.
 *  
 * To override a method from superclass in subclass, that method should be available in subclass first.**** ie Inheritance should exist first
 * ==> private methods of super class are not available in subclasses==> So Private methods can not be over ridden. ***
 * Even if we define the same private method in subclass too, that method is a separate private method defined in subclass but not overridden method
 *  
 * 
 * Arguments :   Must not change . Sub types of arguments can not be considered as part of overriding
   Return type : Can't change except for co-variant (subtype) returns . I.e only for reference types not to primitives
   Exceptions :  Can reduce/eliminate (both checked or unchecked). 
                 Must not throw new/broader checked exceptions 
                 can throw newer or broader run time exceptions
   Access Modifier:         Must not be more restrictive. Can be less restrictive. 
   Which method to call is based on object type, at runtime time 

 * 
 *  Here super class method is: talk(Object obj)
 *  subclass mehod is: talk(String str)
 *  
 *  We can not call this overriding. It is over loading in subclass
 *  
 *  Over-riding argument type must not change at all.
 *
 *
 */
public class SubClass extends SuperClass{

	public static void run(){
		System.out.println("Child is running");
	}
	public void talk(Object lang) {
		System.out.println("child is talking: "+lang);
	}
	
	

}
