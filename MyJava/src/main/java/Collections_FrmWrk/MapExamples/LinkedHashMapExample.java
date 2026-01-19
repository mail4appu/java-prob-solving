package Collections_FrmWrk.MapExamples;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author apparao
 * 
 * HashTable is old one and does not allow null keys or null values
 * HashMap is new one and allows single null Key and many null values
 * Hashtable uses enumerator where as hashmap uses iterator
 * Hashtable is synchronized and where as hashmap not
 * Hashtable and vector are the only collections that use enumerator to traverse
 * 
 * Any collection with Hashing mechanism does not accept duplicates i.e when duplicate occurs it replaces simply. So does not allow duplicates
 * 
 * 
 *   Very good site to know how LinkedHashSet maintains insertion order:
     http://javaconceptoftheday.com/how-linkedhashset-works-internally-in-java/
 * 
 * 
 *
 */
public class LinkedHashMapExample {
	/**
	 * @param args
	 */
	public static void main(String args[]){
		HashMap hm =new HashMap();
		LinkedHashMap lhm=new LinkedHashMap();
		hm.put(1, "ron");
		hm.put(2, "Scott");
		hm.put(7, "cindrella");
		hm.put(4, "mary");
		hm.put(8, "decaprio");
		hm.put(6, "nicolouscage");
		System.out.println("keys in the hashmap"+hm.keySet());//insertion order is not maintained in HashMap
		System.out.println("map contains"+hm);//At times it may be maintaing based on our luck
		/*lhm.put(1, "ron");
		lhm.put(2, "Scott");
		lhm.put(4, "cindrella");
		lhm.put(3, "mary");
		lhm.put(5, "decaprio");
		lhm.put(6, "nicolouscage");
		System.out.println("keys in the linked hashmap"+lhm.keySet());
		System.out.println("linked hashmap contains"+lhm);*/
	}

}
