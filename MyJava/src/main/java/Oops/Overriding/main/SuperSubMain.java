package Oops.Overriding.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import Oops.Overriding.sub.SubClass;
import Oops.Overriding.sup.SuperClass;

/**
 * @author Test
 *  
 *  (AREA)
 * 
 * Private method bears and dies in the same class. 
 * 
 * It can not be invoked/called or available anywhere else other than the class which creates it
 *
 * Overriding happens only in subclass.
 * only methods can be overridden.
 *  
 * To override a method from superclass in subclass, that method should be available in subclass first.****
 * ==> private methods of super lass are not available in subclasses==> So Private methods can not be over ridden. ***
 * Even if we define the same private method in subclass too, that method is a separate private method defined in subclass but not overridden method
 *  
 * 
 * Arguments :   Must not change . Sub types of arguments can not be considered as part of overriding. If at all, sub type is given, it becomes overloading in the subclass
   Return type : Should be same for primitives and can be smaller/sub-type one for reference types
   Exceptions :  Can reduce/remove ( Checked or Unchecked )
                 Must not throw newer/broader checked exceptions 
                 Subclass overridden method can remove the exception completely or reduce the exception level. But new or broader checked exceptions on over ridden method give compile time error
                 New runtime exception can be thrown by overridden method. New run time exception means, super class not throwing any exception where as sub class is throwing a run time exception of any type
   Access Modifier: Must not be more restrictive. Can be less restrictive. 
   Which method to call is based on object type, at runtime time 

 * only access modifier can be more and remaining all should be less
 * 
 * http://www.studytonight.com/java/methodoverriding-with-exception-handling
 *
 *
 */
public class SuperSubMain {
	public static void main(String[] args) throws IOException { //Check after removing exception here
     SuperClass sup= new SubClass();
     //Which object calls the method is decided at run time. Because there is am
     int i=456;
     sup.talk("english");
     sup.talk(i);
    
     SubClass sub= new SubClass();
     sub.talk("Telugu");
     int[] a={1,2,3,};
        System.out.println(a.length);
     
	}
}
