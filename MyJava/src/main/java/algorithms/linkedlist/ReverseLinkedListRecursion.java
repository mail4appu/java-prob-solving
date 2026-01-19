package algorithms.linkedlist;

import Collections_FrmWrk.implementations.linkedList.MyLinkedList;
import Collections_FrmWrk.implementations.linkedList.Node;

/**
 * What does return statement mean
 *
 * ==> Return to the calling area i.e control going back to calling area
 * ===> Return with some value=> Control is going back to calling area with some value
 *
 * ""CONTROL IS GOING BACK TO CALLING POINT WITH SOME VALUE""
 *
 *
 * Expectation=reverse function is going to reverse the given list
 * Faith= reverse function from second node knows to how to return reversed list
 *
 * Meeting Faith & expectation
 * node.next.next=node
 * node.next=null
 *
 * return already reversed list
 *
 * Example: 44->13->19->10->2
 *
 * Faith returns   2->10->19->13   ( tmp points to start of list )
 *
 * So, after faith returns list looks like below
 *
 * 2->10->19->13<-44
 *
 * To meet Faith with Expectation
 *
 * if ( node.next!=null){
 *     node.next.next=node;
 *     node.next=null
 * }
 *
 *
 *
 */
public class ReverseLinkedListRecursion {
	public static void main(String[] args) {
		MyLinkedList list=LinkedListUtil.prepareLinkedList();
		System.out.println("list is before reverse: ");
		list.printList(list.get(0));
		System.out.println("reversed list is: ");
		list.printList(reverseLinkedList(list.get(0)));

	}

	private static Node reverseLinkedList(Node node) {
		Node temp=null;
		if(node==null || node.next==null)
			return node;
		temp=reverseLinkedList(node.next);
		//This is the trick to reverse a pointer. Prepare call stack and their activation records with varaibles. We can understand
		//below logic
		if(node.next!=null) {
			node.next.next = node;
			node.next = null;
		}

		return temp;


	}

}
