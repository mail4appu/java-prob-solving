package Collections_FrmWrk.SetExamples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Test
 * 
 * HashSet add() method returns true for every element when it is added for the first time
 * returns false, for every duplicate element addition
 * 
 *
 */
public class TestSet {
	public static void main(String[] args) {
		Set<String> mySet= 	new HashSet<>();
		System.out.println(mySet.add("abc"));//returns true
		   System.out.println(mySet.add("abc"));//returns false. And the element is not added again
		   System.out.println(mySet.add("def"));//returns true
		   mySet.add("xyz");
		   mySet.add("pqr");
		   System.out.println(mySet);
		   
		   
	}

}
