package Hashing;

import java.util.HashMap;


/**
 * @author apparao
 * 
 * ****If two objects are equal by equals method, They should have same hash codes too*****
 * 
 * Here we are keeping object as key and some String as value in HashMap.
 * Generally we keep object as value and some string as key.
 * 
 * http://www.jitendrazaa.com/blog/java/what-is-the-need-to-override-hashcode-and-equals-method/
 * 
 * Two objects are identical in java, if they return same value in hashcode( i.e o1 returns 123, o2 should also return 123 in hashcode)
 *  and they should return same value in equals( o1 returns true then o2 should also return true in equals())
 *  
 *  We know that hashmap does not allow duplicates, but allows single null key(no duplicates)
 *  
 *  When we put elements in hashmap
 *  
 *  first it checks whether the hashcode of the key is same/present for another element's key
 *  
 *  if hashcodes are same for two keys( Here two movie objects), then it checks for equality of the key content using equals method.
 *  
 *  if the equality method returns different values, then it puts the element in the same bucket. Now the bucket has two elements. These two elements are are 
 *  represented as linked  list
 *  
 *  
 *  When the hash codes are equal for keys and values are also equals method returns same vlaues for keys,  then only it replaces the element in the bucket
 *  
 *  
 *  
 *  Hashmap first checks the hashcodes of the keys, When they are equal only it cheks for the content equality of the keys ******
 *  
 *
 */
public class HashCode_Overriding {
	public static void main(String[] args) {

		
	    Movie m = new Movie();
	    m.setActor("Akshay");
	    m.setName("Thank You");
	    m.setReleaseYr(2011);
	    System.out.println("hashcode of m:  "+m.hashCode());//001

	    Movie m1 = new Movie();
	    m1.setActor("Akshay");
	    m1.setName("Khiladi");
	    m1.setReleaseYr(1993);
	    System.out.println("hashcode of m1:  "+m1.hashCode());//002
	   
	    /*if we look at the m2 and m3 objects, logically they are equal, but jvm returns different hashcodes 
	     * for the two.
	     *  so for achieving logical equality between the objects u should override hashcode() and equals() methods
	     * 
	     * 
	     * */
	    
	    Movie m2 = new Movie();
	    m2.setActor("Akshay");
	    m2.setName("Taskvir");
	    m2.setReleaseYr(2010);
	    System.out.println("hashcode of m2:  "+m2.hashCode());//003
	    
	    Movie m3 = new Movie();
	    m3.setActor("Akshay");
	    m3.setName("Taskvir");
	    m3.setReleaseYr(2010);
	    System.out.println("hashcode of m3:  "+m3.hashCode());//004
	    //m3=m2;
	    if(m3.equals(m2)){
	    	
	    	System.out.println("m2 and m3 are equal");
	    }
	    
	    HashMap<Movie, String> map = new HashMap<Movie, String>();
	    map.put(m, "ThankYou");
	    map.put(m1, "Khiladi");
	    map.put(m2, "Tasvir");
	    map.put(m3, "Duplicate Tasvir");

	    //Iterate over HashMap
	    for (Movie mm : map.keySet()) {
	        System.out.println(map.get(mm).toString());
	    }

	    Movie m4 = new Movie();
	    m4.setActor("Akshay");
	    m4.setName("Taskvir");
	    m4.setReleaseYr(2010);

	    if(map.get(m4) == null ){
	        System.out.println("----------------");
	        System.out.println("Object not found");
	        System.out.println("----------------");
	    }else{
	        System.out.println(map.get(m4).toString());
	    }
	}
}
