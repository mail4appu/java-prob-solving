package Collections_FrmWrk.SetExamples;

import java.util.Scanner;
import java.util.SortedSet;
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
 *  Please remember TreeSet is not from Set interface. It is from SortedSet interface
 *
 */
public class MaintainMinMax {
	public static void main(String[] args) {
		System.out.println("Please enter size of container");
		Scanner sc= new Scanner(System.in);
		//
		SortedSet<Integer> container= new TreeSet<Integer>(); 
		int size=sc.nextInt();
		sc.nextLine();
		System.out.println("Plese enter elements of container");
		for(int i=0;i<size;i++){
			container.add(sc.nextInt());
		}
		sc.nextLine();
		System.out.println("Max number in the container: "+container.last());
		System.out.println("Min number in the container: "+container.first());
	}


}
