package Collections_FrmWrk.MapExamples;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author apparao
 * 
 * For all the Collection framework data structures Iterrator is one way of traversing the collection
 * 
 * i.e 
 * 
 * Iterator is an object which points to the created collection
 * 
 * which implies, when we create iterator for a collection, there are two reference variables in stack that point to the created collection.
 * 
 * one is data structure reference and other is iterator reference. Two variables pointing to the same memory.
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
 *    Structural Modification means simply ***Change in the data structure size**
 *    i.e addition/removal of new elements into the data structure using the **other reference but not by the same reference on which it is being iterated**  and **but not the replace of the elements***.
 *    because replace does not change the size of the data structure.
 *    
 *  Enhanced for loop internally uses iterator. Hence this also throws ConcurrentModificationException
 *  
 * 
 *
 */ class HashMapTest {
	public static void main(String[] args) {

		HashMap<String, String> hmap= new HashMap<String, String>();
		hmap.put("Arun", "Tcs");
		hmap.put("Charan", "Cts");
		hmap.put("Nitin", "Wipro");
		hmap.put("Rajan", "Ibm");
		//very simple technique to iterate over hashmap. but this way of iteration is very inefficient****
		for(String s:hmap.keySet()){
			//Here it throws concurrent modification exception
			if(hmap.get("Rajan").equals("Ibm")){
				hmap.keySet().iterator().remove();
				//hmap.put("Rajan", "Dell");
				
				//hmap.put("Jagan", "JDA");
			}
			System.out.println(hmap.get(s));
		}

		//Efficient way
		for(Entry<String, String> entry:hmap.entrySet()){
			System.out.println(entry.getKey()+"   : "+entry.getValue());
			//the below line makes the above for loop to  throw ConcurrentModificationException
			hmap.put("Jagan", "JDA");
			
		}
		


	}
}
