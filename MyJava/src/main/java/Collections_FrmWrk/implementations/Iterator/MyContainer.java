package Collections_FrmWrk.implementations.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyContainer {
	
	List<String> items;
		
	MyIterator myIterator;
	public MyIterator getIterator(){
		return new MyIterator();

	}
	public MyContainer() {
		this.items=new ArrayList<String>();
		this.items.add("appu");
		this.items.add("Bujji");
		this.items.add("Sid");
		this.items.add("yadi");
	}

	 class MyIterator implements Iterator{
		
		
		int index;

		
		
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
	
	
	
}
