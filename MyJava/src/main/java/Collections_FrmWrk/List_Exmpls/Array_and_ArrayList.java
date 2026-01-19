package Collections_FrmWrk.List_Exmpls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Test
 * 
 * Arrays.asList() returns the list view on the existing array. it acts like a wrapper. It is a fixed size list.
 *  Here the asList will not create a new array/arrayList in the memory location. 
   It uses the existing array and returns the list view of that array
   
   this is best useful  when we want to reverse the array elements
   Collections.reverse(list)----it accepts only list(Arrays class doesnt have reverse method)
   
   Collections.reverseOrder() returns comparator object to sort the list in reverse order
   
   
   ArrayList's add method always appends at the end of the list. i.e adds the element at the index callex size
 *
 */
public class Array_and_ArrayList {
	public static void main(String args[]){
	String a[] = {"1","2","3", "5", "8", "6", "4"};

	List<String> listFrmArray= Arrays.asList(a);

	System.out.println(a.hashCode());
	System.out.println(listFrmArray.hashCode());

	a[1]="abcd";
	System.out.println("List From array "+listFrmArray+"size of the array list:  "+listFrmArray.size());
	//replacing the element at position 2
	listFrmArray.set(2, "appu");
	System.out.println("List From array "+listFrmArray+"size of the array list"+listFrmArray.size());
	Collections.reverse(listFrmArray);
	System.out.println(listFrmArray);
	Collections.sort(listFrmArray);

	//listFrmArray.add("12");
	System.out.println(listFrmArray);
	//Inserting the element at position 2. I.e rest of the elements from postion 3 are shifted to right. Using System.arrayCopy()
	//Here we get unsupported operation exception
	listFrmArray.add(1, "appu");
	System.out.println(listFrmArray);
	
	ArrayList al = new ArrayList();
	
	
	
	
	
	}

}
