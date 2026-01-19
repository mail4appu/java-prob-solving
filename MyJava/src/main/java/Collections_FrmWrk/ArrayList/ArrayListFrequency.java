package Collections_FrmWrk.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ArrayListFrequency {
	public static void main(String args[]){
		ArrayList<Integer> al= new ArrayList<Integer>();
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
		
		
		Map<Integer, Integer> hm= new HashMap<Integer, Integer>();
		
		//always replace if else with conditional operator
		/*for(int i=0;i<al.size();i++){
			if(hm.containsKey(al.get(i))){
				count=(Integer)hm.get(al.get(i))+1;
			}
			else{
				count=1;
				
			}
			hm.put(al.get(i), count);
		
				
			
		}*/
		for(int i=0;i<al.size();i++){
			//get() method in HashMap always returns null, if the key does not exist
			//null should always be assigned to Object type  but not to primitive type
			//int occurance=hm.get(al.get(i)); this throws NPE bc null can not be assigned ot primitive
			
			Integer occurance=hm.get(al.get(i));
			
			hm.put(al.get(i), occurance==null?1:occurance+1);
			
			
		}
		System.out.println("hashmap contains"+hm);
	}

}
