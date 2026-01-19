package algorithms.linkedlist;

import Collections_FrmWrk.implementations.linkedList.MyLinkedList;
import Collections_FrmWrk.implementations.linkedList.Node;

public class KthNodeFromEnd {
	static int kDistance=3;

	public static void main(String[] args) {
		MyLinkedList list=LinkedListUtil.prepareLinkedList();
		getKthNodeFromEnd(list.get(0));


	}

	private static int getKthNodeFromEnd(Node head) {
		//Assume this is our head node
		int i=0;
		Node current=head;
		if(current==null){
			return 0;
		}
		i=getKthNodeFromEnd(current.next)+1;
		if(i==kDistance){
			System.out.println("node at distance k from end:  " +current);
			System.exit(0);
		}

		return i;
	}

}
