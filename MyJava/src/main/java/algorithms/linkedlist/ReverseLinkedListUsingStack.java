package algorithms.linkedlist;

import java.util.Stack;

import Collections_FrmWrk.implementations.linkedList.MyLinkedList;
import Collections_FrmWrk.implementations.linkedList.Node;

public class ReverseLinkedListUsingStack {

	public ReverseLinkedListUsingStack() {
		// TODO Auto-generated constructor stub
	}
	static MyLinkedList list=LinkedListUtil.prepareLinkedList();
	public static void main(String[] args) {
		
		//MyLinkedList list=LinkedListUtil.prepareLinkedList();
		System.out.println("list is: ");
		list.printList(list.get(0));
		ReverseLinkedList(list.get(0));
		
	}

	private static void ReverseLinkedList(Node node) {
		Stack<Node> stack= new Stack<Node>();
		stack.push(node);
		while( node.next!=null){
			node=node.next;
			stack.push(node);
		}
		//point head to first element of stack
	   Node head= stack.peek();
	   stack.pop();
	   //make a temp node, to traverse
	   Node temp=head;
		while(!stack.isEmpty()){
			temp.next=stack.peek();
			stack.pop();
			temp=temp.next;
		}
		//last nodes next points to null
		temp.next=null;
		System.out.println("reversed list is");
		list.printList(head);
	}

}
