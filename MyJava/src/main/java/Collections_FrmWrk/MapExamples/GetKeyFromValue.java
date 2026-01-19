package Collections_FrmWrk.MapExamples;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Test
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
 *
 */
public class GetKeyFromValue {
	public static void main(String[] args) {
		Map<Integer, String> hmap = new HashMap<Integer, String>();
        hmap.put(10, "a");
        hmap.put(20, "b");
        hmap.put(30, "c");
        hmap.put(40, "d");
        
        for (Entry<Integer, String> entry : hmap.entrySet()) {
            if (entry.getValue().equals("c")) {
                System.out.println(entry.getKey());
            }
        }
        
       
    }

}
