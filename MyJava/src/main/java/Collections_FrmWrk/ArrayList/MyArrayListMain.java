package Collections_FrmWrk.ArrayList;

import java.util.Arrays;

public class MyArrayListMain {
	public static void main(String[] args) {

		String[] myarr= new String[50];
		myarr[0]="10";
		myarr[12]="34";
		System.out.println(myarr[2]);
		System.out.println(Arrays.toString(myarr));
		System.out.println(myarr.length);
		MyArrayList myList= new MyArrayList();
		myList.add("appu");
		myList.add("maddy");
		myList.add("raj");
		myList.add("bhanu");
		System.out.println("List size: "+myList.size());
		
		myList.add(2, "sid");
		System.out.println("List size: "+myList.size());
		System.out.println(myList.get(4));
		System.out.println(""+myList.remove(1));
		System.out.println(myList.get(1));
		
	}

}
