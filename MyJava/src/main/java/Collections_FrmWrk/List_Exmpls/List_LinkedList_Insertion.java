package Collections_FrmWrk.List_Exmpls;

import java.util.ArrayList;
import java.util.LinkedList;

public class List_LinkedList_Insertion {
/**
 * @param args
 */
public static void main(String []args){
	int  len = 100000;
    LinkedList linkedLst = new LinkedList(); 
    ArrayList  arrayLst = new ArrayList();
   
    for (int m =0; m!= len; m++) {
      arrayLst.add(m);
      linkedLst.add(m);
    
    }
    //linked list insertions in the middle are fast than arraylist insertioins in the middle
    //System.out.println("size of list"+linkedLst.size());
    long t = System.currentTimeMillis();
    for(int i=0;i<100000;i++){
    	if(i%5==0){
    		
    		arrayLst.add(i, i+5);
    		//linkedLst.add(i, i+5);	
    		
    	}
    }
    t = System.currentTimeMillis() - t;
    System.out.println("LIst insertions --  takes "+t +"(ms)");

}
}
