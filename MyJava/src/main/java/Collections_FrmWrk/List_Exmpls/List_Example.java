package Collections_FrmWrk.List_Exmpls;

import java.util.ListIterator;
import java.util.Vector;

/**
 * @author apparao
 * 
 * All array based collections have default capacity. i.e All these Collections have constructor that takes capacity
 * 
 * ArrayList, HashMap, HashTable, HashSet and Vector
 *    |         |          |                    |        
 *    | 10      |16        | 11                 |10
 *    
 *    
 *  And StringBuffer/Builder has capacity of 16 ie. buffer size
 *    
 *  As the list accepts duplicates, index(no) gives the first occurance of the element
 *  
 *  Thats why we have lastIndexOf() method in list interface
 *  
 *  Arrays.equals(a1, a2) to check the equality of two arrays
 *  list1.equals(list2) to check the equality of two lists==> if list contains another list
 *  then equals does not work properly
 *  
 *  Listiterator is derived from iterator only.
 *  List iterator is capable of traversing in both forward and backward directions
 *  
 *  Every class from Collection interface i.e ArrayList, Vector, LinkedList, HashSet, LinkedHashSet
 *  accept other other Collection class as argument in the constrcutor****
 *  
 *  HashMap/Table is not from Collection interface
 * 
 * 
 *
 */
public class List_Example {
	public static void main(String []args){
		
	
	Vector<String> vect1 = new Vector<String>();
	vect1.addElement("Raju");
    vect1.addElement("Reddy");
    vect1.addElement("Rao");
    vect1.addElement("Ratnakar");
    ListIterator<String> it1 = vect1.listIterator();
    System.out.print("Elements with next() method: ");		
    while(it1.hasNext())
    {
      Object obj1 = it1.next();
      System.out.print(obj1 + " ");
    }
                     // let us take the cursor backwards
    System.out.print("\nElements with previous() method: ");	
    while(it1.hasPrevious())
    {
      Object obj2 = it1.previous();
      System.out.print(obj2 + " ");
    }
                                          // affecting the elements  
    while(it1.hasNext())
    {
      Object obj1 = it1.next();
 
      if(obj1.equals("Raju"))
            it1.remove();                     // Raju is removed from the original list also
 
      if(obj1.equals("Reddy"))   // Reddy replaced by Yadav
            it1.set("Yadav");  
    }
    it1.add("Jyothi");// 
    it1.add("Jyostna");
                        // now let us print the elements after affecting
    ListIterator<String> it2 = vect1.listIterator();
    System.out.print("\nElements after operations: ");
    while(it2.hasNext())
    {
      Object obj2 = it2.next();
      System.out.print(obj2 + " ");
   }

}
}
