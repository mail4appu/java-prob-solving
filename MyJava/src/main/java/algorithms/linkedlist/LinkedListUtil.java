package algorithms.linkedlist;

import Collections_FrmWrk.implementations.linkedList.MyLinkedList;
import Collections_FrmWrk.implementations.linkedList.Node;

public class LinkedListUtil {

	public LinkedListUtil() {
		// TODO Auto-generated constructor stub
	}

	public static MyLinkedList prepareLinkedList(){
		MyLinkedList list= new MyLinkedList();
		//Object obj=new Object();
		//obj=30;
		//System.out.println(obj.toString());
		Node n1=new Node(1);

		Node n2=new Node(13);
		Node n3= new Node(5);
		Node n4=new Node(3);
		Node n5= new Node(1);
		Node n6= new Node(9);
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.add(n5);
		//list.add(n6);



		return list;
	}

}
