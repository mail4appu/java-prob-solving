package Collections_FrmWrk.List_Exmpls;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author vapparao
 * 
 * Iterator is faster because, every time it goes to next element, it maintains the pointer
 * 
 * Example: LinkedList =[a, b, c, d, e]
 * 
 * To access a single element, using get or iterator takes same time almost for linked list.
 * but when we  access all the elements in a loop, there is significant difference in the usage of get() or iterator
 * 
 * Uinsg get(index):(in a loop)
 * to access a: a
 * to acess b: a and b
 * to access c : a, b and c
 * to access d:  a, b, c and d
 * 
 * 
 * using Iterator:(in a loop)
 * to access a: a
 * to access b: b (because the pointer will be at 'a' after first iteration)
 * ta access c: c ( the pointer will be at b after b's iteration)
 * 
 * etc
 * 
 * 
 * Linked list has no concept called capacity. bc it is not array based
 * 
 * LinkedList elements are not stored in contiguous memory locations****
 * 
 * LinkedList myList = new LinkedList();
   List yourList = Collections.synchronizedList(myList); - 
See more at: http://way2java.com/collections/linkedlist-tutorial/#sthash.qHGflvdd.dpuf
    
    Now yourList is synchronized. Still myList is not synchronized. *****
    
    Collection c = Collections.synchronizedCollection(myCollection);
     ...
  synchronized (c) {
      Iterator i = c.iterator(); // Must be in the synchronized block(java doc says this)
      while (i.hasNext())
         foo(i.next());
  }
 
 Legacy classes only use enumerator. Modern classes use iterator only.
 Iterator is universal cursor as  It is applicable for all classes uneder Collection interface
 Enumeration is meant for only read operation
 Iterator is meant for read and remove operations
 
 ListIterator is bi-directional cursor. this is the most powerful cursor
 We can perform read, remove, replace and addtion operations can be performed
 
 Circular Linked list best explained :
 
 https://www.youtube.com/watch?v=apIw0Opq5nk
 
 
 * 
 * 
 *
 */
public class List_LinkedList_Example {
	public static void main(String[] args) {
	    int  len = 100000;
	    LinkedList linkedLst = new LinkedList(); 
	    ArrayList  arrayLst = new ArrayList();
	    for (int m =0; m!= len; m++) {
	      int x = (int)Math.random();
	      linkedLst.add(m);
	      arrayLst.add(m);
	    }
	    
	    long t = System.currentTimeMillis();
	    for (int i = 0; i!=len; i++) {
	      linkedLst.get(i);//is a sequential access hence takes more time 
	    }
	    t = System.currentTimeMillis() - t;
	    System.out.println("LinkedList -- get(index) takes "+t +"(ms)");

	    t = System.currentTimeMillis();
	    for  (Iterator itr = linkedLst.iterator();
	      itr.hasNext();) {
	      itr.next();     		
	    }		
	    t = System.currentTimeMillis() - t;
	    System.out.println("LinkedList -- Iterator takes "+t +"(ms)");//Using iterator for linked list wil reduce the traversing time by few 1000s of times
	    
	    t = System.currentTimeMillis();
	    for (int i = 0; i!=len; i++) {
	      arrayLst.get(i);//random access hence takes less time
	    }
	    t = System.currentTimeMillis() - t;
	    System.out.println("ArrayList -- get(index) takes "+t +"(ms)");

	    t = System.currentTimeMillis();
	    for  (Iterator itr = arrayLst.iterator();
	           itr.hasNext();) {
	      itr.next();     		
	    }		
	    t = System.currentTimeMillis() - t;
	    System.out.println("ArrayList -- Iterator takes "+t +"(ms)");
			
	  }
}
