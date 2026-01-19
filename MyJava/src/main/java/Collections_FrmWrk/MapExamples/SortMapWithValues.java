package Collections_FrmWrk.MapExamples;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Test
 * 
 *  Here the simplest solution is
 *    Writing value comparator.
 *    
 *    Trick is : The comparator is always given to some sorting api or a datastructure of this nature
 *    
 *    SortedMap is interface, TreeMap is its implementing class
 *    
 *    so while instantiating the TreeMap we can give the comparator object.
 *    
 *    Here the compare method is called for every entry in the map. We dont call compare method for every element in the data structure
 *    
 *  
 *  
 *  
 *  3 methods to remember in the HashMap
 *  
 *  entry objects: map.entrySet()
 *  keys:    map.keyset();
 *  values:  map.values();
 *  
 *  Iterating over map.entrySet() gives you an option to get key when you know a value in map
 *  
 *  http://www.mkyong.com/java/how-to-sort-a-map-in-java/
 *  http://www.programcreek.com/2013/03/java-sort-map-by-value/
 *  
 * 
 *
 */
public class SortMapWithValues {
	public static void main(String[] args){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 10);
		map.put("b", 30);
		map.put("c", 50);
		map.put("d", 40);
		map.put("e", 20);
		System.out.println("original map: "+map);
 
		System.out.println("ordered by value map:  "+SortByValue(map));
	}
 
	public static TreeMap<String, Integer> SortByValue(HashMap<String, Integer> map) {
		ValueComparator vc =  new ValueComparator(map);
		TreeMap<String,Integer> treeMap = new TreeMap<String,Integer>(vc);
		treeMap.putAll(map);
		return treeMap;
	}
}
 
class ValueComparator implements Comparator<String> {
 
    Map<String, Integer> map;
 
    public ValueComparator(Map<String, Integer> base) {
        this.map = base;
    }
 
    public int compare(String key1, String key2) {
        return map.get(key1)-map.get(key2);
    }
}


