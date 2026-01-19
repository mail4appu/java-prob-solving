package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author apparao
 * 
 * Sort can happen, only with elements that are comparable to each other.
 * If a Normal list i.e non generic list is given to Collection.sort(), then it will
 * give ClassCastException.
 * 
 * Digits can be compared to each other and alphabets can be compared to each other.
 * Alphabets and digits can be compared to each other mutually if each digit and alphabet is accessed as character
 * All ascii chars(256) are comparable to each other
 * All characters, can be compared ie alphabets(a to z) and digits(0 to 9) can be compared mutually but as characters only
 * i.e String like "a12wsd3", "32wer45d" can be sorted.
 * 
 * after sortig: 123adsw, 2345derw.
 * 
 * first numbers are sorted and then alphabets. This is lexographic order
 * 
 * Negative numbers are not characters
 *  -1, -2 are not characters. Application throws compilation errors
 *
 */
public class ListSortTest {
	public static void main(String[] args) {
		List al= new ArrayList();
		al.add('1');
		//al.add('-1');
		al.add('2');
		al.add('s');
		al.add('d');
		al.add('3');
		al.add('t');
		al.add('y');
		al.add('+');
		al.add('-');
		al.add('*');
		al.add('/');
		al.add('%');
		al.add('S');
		//To be able to sort, elements should be comparable
		
		Collections.sort(al);
		System.out.println(al);
		
		List strList=new ArrayList();
		strList.add("appu");
		strList.add("bujji");
		Collections.sort(strList);;
		System.out.println(strList);
		
		
		
	}
	

}
