package Collections_FrmWrk.List_Exmpls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author vapparao
 *
 *Collections.reverese and binarayserach always accesps lists only
 *these will not create a new list
 *but whereas Collections.unmodyfiableList(), Collections.synchronizedList() etc
 *will give unmodifiable view only i.e not the unmodifiable data structure
 *still the list can be changed with original reference.
 *
 *But the list can not be changed with the reference returned from Collections.unmodyfiableList()
 *
 
 *UnModifiableCollection==>
 *  new elements can not be added/removed
 *  Existing elements can not be replaced
 *  
 *  i.e with that reference, we can not do any operations on list
 *  
 *  Where as Arrays.asList() returns list view of the array
 *    and supports the replace of the elements
 *    
 *    
 *    Addition/deletion of elements throw UnSupportedOperationException
 *  
 *  
 *  
 *    NOTE: Unmodifiable collections are unmodifiable through that reference only, 
 *    but some other reference may point to the original data structure  through which it can be changed.
 *    
 *    
 *    In the below example al2 is just a wrapper around al.
 *    al2 is not new data structure. Its a glassy sphere around original object. So its address will be different the original address
 *    
 *    Here modifications to data structure are not permissible via al2 but al can modify
 *    
 *    So here al2 is unmodifiable reference
 *
 *
 */
public class CollectionsReverse {
	public static void main(String[] args) {
		final ArrayList al = new ArrayList();
		al.add("a");
		al.add("b");
		
		ArrayList al3=al;
		final List al2=Collections.unmodifiableList(al);//This returns a list view of the existing list
		
		
		if(al == al3){
			System.out.println("view only");
		}
		//here al2 is like a wrapper around the original list. like a circle or glassy sphere around the object(rectangular box)
		//so its address will be different
		if(al==al2){
			System.out.println("true");
		}
		else{
			System.out.println("false");
		}
		
		//List al3=Collections.synchronizedList(al);
		//Still we can new elements to the first collectiion
		al.add("c");
		al.add("d");
		System.out.println(al);
		System.out.println("*****:  "+al2);
		al2.add("e");
		Collections.reverse(al2);
		System.out.println(al);
		System.out.println(al2);
	}

}
