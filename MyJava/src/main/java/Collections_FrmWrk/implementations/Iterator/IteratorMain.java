package Collections_FrmWrk.implementations.Iterator;

import java.util.Iterator;

public class IteratorMain {
	public static void main(String[] args) {
		MyContainer names= new MyContainer();
		Collections_FrmWrk.implementations.Iterator.MyContainer.MyIterator it=names.getIterator();
		System.out.println(it);
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	


}
