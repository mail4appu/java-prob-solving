package Collections_FrmWrk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetandListperformance {
	public static void main(String args[]){
		
	
	List li= new ArrayList();
	Set set= new HashSet();
	
	for(int i=0;i<100000;i++){
		li.add(i);
		//set.add("appu"+i);
	}
System.out.println(Collections.binarySearch(li, 
		9999));

}
}
