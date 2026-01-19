package Collections_FrmWrk.List_Exmpls;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class List_LinkedList_InsertionTest {
	public static void main(String[] args) {
		LinkedList<Integer> linkedLst = new LinkedList<Integer>(); 
	    ArrayList<Integer>  arrayLst = new ArrayList<Integer>();
	    
	    for(int i=0;i<5;i++){ //arrayList=[0, 1, 2, 3, 4]
	    	linkedLst.add(i);
	    	arrayLst.add(i);
	    }
	    //insert at third position
	    //System.arraycopy(this.elementData, paramInt, this.elementData, paramInt + 1, this.size - paramInt); from arraylist clas
	    long start=System.nanoTime();
        arrayLst.add(2, 6);
	    long end=System.nanoTime();
        System.out.println("time for arrayList is: "+(end-start));
        System.out.println(":   "+arrayLst); //[0, 1, 6, 2, 3, 4]
	    //i.e 2, 3 and 4 elements are moved one positoin to the right
       
        
        long startL=System.nanoTime();
         linkedLst.add(5, 6);
       // Iterator it=linkedLst.iterator();
        //while(it.hasNext()){
        	//if((Integer)it.next()==2){
        		
        	//}
        //}
        long endL=System.nanoTime();
        System.out.println("time for Linked List is: "+(endL-startL));
        System.out.println("Linked list is:   "+linkedLst);
        
	    
	}

}
