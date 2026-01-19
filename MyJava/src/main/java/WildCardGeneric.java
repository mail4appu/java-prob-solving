import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class WildCardGeneric {
	public  void printCollection(List<?> u){//see the compilor error by replacing ? with T
		//because ? means unknown type, T is some type which is defined
		                                         //									
		System.out.println("the collection contains"+u );
	}
	public static void main(String []args){
		//Collection<?> listOfUnknown =null; 
		List<Integer> strList= new ArrayList<Integer>();
		strList.add(1);
		strList.add(2);
		
		//listOfUnknown=strList;
		WildCardGeneric wcg= new WildCardGeneric();
		wcg.printCollection(strList);
	}

}
