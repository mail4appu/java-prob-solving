package Collections_FrmWrk.MapExamples;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
	public static void main(String[] args) {
		ConcurrentHashMap<String, String> chmap= new ConcurrentHashMap<String, String>();
		chmap.put("Arun", "Tcs");
		chmap.put("Charan", "Cts");
		chmap.put("Nitin", "Wipro");
		chmap.put("Rajan", "Ibm");
		//Inefficient way of iterating
		for(String s:chmap.keySet()){
			System.out.println(chmap.get(s));
			//Normal HashMap throws ConcurrentModificationException where as chmap does not
			chmap.put("Jagan", "JDA");
		}
		
	}

}
