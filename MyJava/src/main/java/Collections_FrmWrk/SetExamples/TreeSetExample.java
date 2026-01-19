package Collections_FrmWrk.SetExamples;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Test
 * 
 * The purpose of tree set
 * 
 * There is a scenario, where program is  accessing series of integers or numbers frequently or may be for every 2 secs, 
 * and all the time the program needs to maintain the max/min of all the entered series so far ,
 * Then tree set is for rescue. No other data structure provides this functionally except TreeSet
 * 
 * We have last() and first() methods defined in tree set which give min or max of entered series*****
 * 
 *  
 *
 */
public class TreeSetExample {
	
	public static void main(String []args){
		//Set set= new TreeSet();//Elements added in treeset should be mutually comparable. Else it throws 
		                       //ClassCastException
		/*set.add(1);
		set.add("appu");*/
		Set lset= new LinkedHashSet();//in the linked-hashset insertion order is maintained as opposed to HashSet
		lset.add("hi");
		lset.add("bye");
		lset.add("gudbye");
		System.out.println("lset contains"+lset);
		Set set= new TreeSet(lset);
		System.out.println("tree set contains"+set);
		
	}

}
