package Collections_FrmWrk.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author vapparao
 * default array of size 0 is created btu capacity 10 . But not the array of size 10
 * the capacity 10 means "space reserved for elements i.e initial space of size 10 is chossen by jvm"
 * so till we add 10 elements, the same array grows in the same space.
 * once this size goes beyond 10, it checks for next available space, with incremented mechanism
 * 
 * 
 * General Expectation:
 * when we print list of size two , only those two elements are printed.
 * we might expect other 8 elements of the array should be nulls
 * and when we insert, if we add element at an index greater than the size,
 * it throws arrayIndexOutofbounds exception
 * 
 * For all the Collection framework data structures Iterator is one way of traversing the collection
 * 
 * i.e 
 * 
 * Iterator is an object which points to the created collection
 * 
 * which implies, when we create iterator for a collection, there are two reference variables in stack that point to the created collection.
 * 
 * one is data structure reference and other is iterator reference. Two variables pointing to the same memory Location.
 * 
 *  
 *  while iterating over the collection using iterator reference, we can modify the collection using the other reference ( list or hmap or any reference)
 *  
 *  In this scnerio, ***it.next()*** method throws ConcurrentModificationException
 *  
 *  Iterator works in the following way---
 *    After iterator is created from any collection reference, if any structural modification occurs to the data structure before it.next() method is called
 *    then it throws ConcurrentModificationException
 *    
 *    ConcurrentModificationException is thrown by it.next() method.
 *    
 *    Structural Modification means simply ***Change in the data structure size**
 *    i.e addition/removal of new elements into the data structure using the **other reference but not by the same reference on which it is being iterated**  and **but not the replace of the elements***.
 *    because replace does not change the size of the data structure.
 *    
 *  Enhanced for loop internally uses iterator. Hence this also throws ConcurrentModificationException
 *  
 *  
 *  Iterator has remove method, This iterator can remove the elements from the data structure. 
 *  this removal actually removes from the underlying data structure. But this does not throw ConcurrentModificationException.
 *  
 *  This Exception is thrown, only when the other reference (Actual reference) of the data structure changes the size of the data structure 
 *  
 *  
 *  NOTE: You can say, without modifying the size, we can add an element and remove that element. This is not size modification
 *  Even in this case, it throws ConcurrentModificationException
 *  
 * 
 */

public class ArrayListTest {
public static void main(String[] args) {
	List<String> al= new ArrayList<String>(10);
    System.out.println("Initial Size of Array: "+al.size());
	al.add("appu"); //appends the element to the end of the list
	System.out.println("Size after adding one element: "+al.size());
	al.add("bujji ");
	al.add("sid");
	System.out.println("size after adding some more: "+al.size());
	al.add(3, "maddy"); //inserts the element at postion 3. We can always add elements to the end of the arraylist but not beyond its end
	al.toArray();

	Iterator it= al.iterator();
	System.out.println("Original list "+al);
	//al.remove(0);
	while(it.hasNext()){
		//al.remove(0);
		al.set(0, "raj");
		System.out.println("After replacing the first element: "+al+"   size after replacing: "+al.size());
		System.out.println("it:  "+it.next());
		it.remove();
		System.out.println("After removing  element: "+al+"   size after replacing: "+al.size());
		System.out.println("it:  "+it.next());
		//al.remove(0);
		System.out.println(""+al.size());
		
		
		
	}
	System.out.println(al);
	for(String s:al){
		System.out.println("inside enhanced for loop:  "+s);
		al.remove("raj");
		
	}
	
	int size=al.size();
	/*for(int i=0;i<size; i++){
		al.add("bye");
		System.out.println(al.get(i));
		}*/
	System.out.println(""+al);
}
}
