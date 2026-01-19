package Collections_FrmWrk.implementations.Iterator;

import java.util.Iterator;
import java.util.List;

public class MyIterator implements Iterable{
	
	List items;
	
	int index;

	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean hasNext(){
		return index<items.size();
	}

   public Object next(){
	   return items.get(index++);
	   
   }
   
   public void remove(){
	   items.remove(index--);
   }
	
}
