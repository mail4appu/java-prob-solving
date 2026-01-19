import java.util.ArrayList;
import java.util.HashMap;


public class ArrayListFrequency {
	public static void main(String args[]){
		ArrayList al= new ArrayList();
		al.add(10);
		al.add(11);
		al.add(12);
		al.add(11);
		al.add(12);
		al.add(10);
		al.add(10);
		al.add(10);
		al.add(10);
		al.add(13);
		al.add(15);
		al.add(11);
		al.add(10);
		al.add(10);
		al.add(11);
		al.add(12);
		al.add(11);
		al.add(12);
		al.add(10);
		al.add(10);
		al.add(10);
		al.add(10);
		al.add(13);
		al.add(15);
		al.add(11);
		al.add(10);
		al.add(10);
		al.add(11);
		al.add(12);
		al.add(11);
		al.add(12);
		al.add(10);
		al.add(10);
		al.add(10);
		al.add(10);
		al.add(13);
		al.add(15);
		al.add(11);
		al.add(10);
		al.add("Numéro de téléphone");
		
		
		HashMap hm= new HashMap();
		int count=1;
		for(int i=0;i<al.size();i++){
			if(hm.containsKey(al.get(i))){
				count=(Integer)hm.get(al.get(i))+1;
			}
			else{
				count=1;
				
			}
			hm.put(al.get(i), count);
		
				
			
		}
		System.out.println("hashmap contains"+hm);
	}

}
