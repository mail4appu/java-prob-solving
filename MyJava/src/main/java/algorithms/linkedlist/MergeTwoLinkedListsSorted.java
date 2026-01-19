package algorithms.linkedlist;

import Collections_FrmWrk.implementations.linkedList.MyLinkedList;
import Collections_FrmWrk.implementations.linkedList.Node;

public class MergeTwoLinkedListsSorted {
	public static void main(String[] args) {
		MyLinkedList list1= new MyLinkedList();
		list1.add(new Node(4));list1.add(new Node(8));list1.add(new Node(10));list1.add(new Node(15));
		System.out.println("list 1: ");
		list1.printList(list1.get(0));

		MyLinkedList list2= new MyLinkedList();
		list2.add(new Node(2));list2.add(new Node(6));list2.add(new Node(7));list2.add(new Node(16));
		System.out.println("list2 :");
		list2.printList(list2.get(0));
		
		//This is not the way to print list. but for testing
		list1.printList(mergeLists(list1.get(0), list2.get(0)));

	}



	private static Node mergeLists(Node headA, Node headB) {
		Node result=null;
		if(headA==null){
			return headB;
		}
		else if(headB==null){
			return headA;
		}
		int dataA=(Integer)headA.data;
		int dataB=(Integer)headB.data;
		if(dataA<=dataB){
			result=headA;
			result.next=mergeLists(headB, headA.next);
		}
		else{
			result=headB;
			result.next=mergeLists(headA, headB.next);
		}
		return result;

	}

}
