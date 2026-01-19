package features;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Boxing_Unboxing {
	public static void main(String[] args){
		List list = new LinkedList();
		list.add("foo");
		//list.add(new Integer(7));

		ArrayList<Integer> al= new ArrayList<Integer>();
		al.add(1);//converting primitive to wrapper ---boxing
		al.add(new Integer(5));
		System.out.println("array list contains"+al);
		int j=al.get(1);//converting wrapper to primitive---unboxing
		System.out.println(" element at the index 1   "+j);
		for (int i = 0; i < list.size(); i++) {
			String s = (String)list.get(i);
			}
	}

}
