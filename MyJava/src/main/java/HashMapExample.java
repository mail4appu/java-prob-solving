import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class HashMapExample {
	public static void main(String[] args) {
		HashMap<String, String> hMap = new HashMap<String, String>();

		hMap.put("1", "One");
		hMap.put("2", "Two");
		hMap.put("3", "Three");
		Set<Map.Entry<String, String>>  set=hMap.entrySet();//only three methods in the hmap are imp
		//hm.entrySet(), hm.keySet(), hm.values()
		System.out.println("set contains"+set);
		Iterator it=set.iterator();
		Set s1=hMap.keySet();
		System.out.println("key set conatins"+s1);
		Collection c=hMap.values();
		System.out.println("Collection contains"+c);
		while(it.hasNext()){
			Map.Entry<String, String> m=(Map.Entry<String, String>)it.next();
			System.out.println("key "+m.getKey()+"          "+"value is"+m.getValue());
		}

	}
}
