package algorithms.linkedlist;

import Collections_FrmWrk.implementations.linkedList.MyLinkedList;
import Collections_FrmWrk.implementations.linkedList.Node;

/**
 * @author evarapp
 * 
 * 
 * Trick: Copy the middle node's next node to middle node
 * 
 *  see the below link
 *  https://www.youtube.com/watch?v=Cay6RsoIG78
 *
 */
public class DeleteNodeAtPointerInLinkedList {
	public static void main(String[] args) {
		MyLinkedList linkedList= new MyLinkedList();
		linkedList.add(new Node(30));
		linkedList.add(new Node(40));
		linkedList.add(new Node(20));
		linkedList.add(new Node(10));
		linkedList.add(new Node(50));

		System.out.println("size of linked list:   "+linkedList.getLength());
		linkedList.printList(linkedList.get(0));

		Node middle= linkedList.get(2);
		//copy the middlenode's next node data to middle node
		Node temp=middle.next;
		middle.data=temp.data;
		middle.next=temp.next;
		System.out.println("linked list after removal of middle node *******");
		linkedList.printList(linkedList.get(0));


	}


}
