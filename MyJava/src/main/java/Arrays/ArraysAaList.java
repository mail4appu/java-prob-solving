package Arrays;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * 
 * 
 * @author vapparao
 * Here myList from Arrays.asList() is view of existing array
 * it is a wrapper on the array
 * i.e both myarray and myList point to same array
 * i.e myList uses the same array as it does not create another array
 * 
 * ****but list.toArray(al) returns completely new Array
 * 
 * Arrays.asList(myarray). gives a fixed size list view only
 * hence elements can not added to removed. But elements can be replaced
 * if done "UnsupportedOperationException"
 * 
 * if we want to create an arrayList with array that actually behaves like a list 
 * 
 *  ArrayList al2 = new ArrayList(myarray.length); //Constructing arraylist with capacity but not size
 *  Collections.addAll(al2, myarray);
 * 
 * 
 * Arrays.asList(a1); to get fixed size list as it uses the same array
 * Arrays.toString() to print array elements
 * Arrays.equals(a1, a2) to compare two arrays
 * arrays.hashCode(a1) to return the hascode of the entire array *********
 * 
 * with asList() only replace works i.e set(index, object)
 * 
 *  
 *
 */
public class ArraysAaList {
	public static void main(String[] args) {
		String[] myarray= new String[5];
		myarray[0]="appu";
		myarray[1]="Poori";
		List<String>  myList=Arrays.asList(myarray);
		System.out.println("List size after creation:   "+myList.size());
		myarray[2]="sid";
		myList.set(0, "raja"); //replace works 
		System.out.println("arrys is"+Arrays.toString(myarray));
		//myList.remove(0); // unspported operation exception
		myList.add(0,"raja"); //Here it throws unSupportedOperation Exception
		myList.add("yadhi");// Here it gives unsupportedOperation Exception
		System.out.println("arrys is"+Arrays.toString(myarray));
		System.out.println("\n list is"+myList);
		Collections.reverse(myList);
		System.out.println("array is"+Arrays.toString(myarray));
		System.out.println("\n list is"+myList);
		
	}

}
