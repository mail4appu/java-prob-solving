package Collections_FrmWrk.implementations.linkedList;

/**
 * @author Test
 * 
 * Here head is a variable in the stack which is not pointing to anything( ie null) . Like any other primitive variable this is a Node variable.
 * in the same way temp too in the local methods
 * 
 * trick to implement linked list is head variable which is in stack and temp(for local methods) variable which is also in stack 
 * And getLast() and getLength()  methods are very important
 * 
 *  In the beginning of any method of this class, point temp to head;
 * 
 * i.e temp is pointing to a object where head is pointing to
 * 
 * while(temp.next!=null){
 *   temp=temp.next
 *   }
 *
 * in the above while loop we are moving temp variable to one node next. i.e it goes till, the last node
 * 
 * ie. we are traversing the nodes one by one using a stack variable
 * 
 * one more trick is, getLast() method, Because this is used in other methods
 *  
 *
 */
public class MyLinkedList {
	Node head;

	public Node getLast(){
		Node temp=head;
		while(temp.next!=null){
			temp=temp.next;
		}
		return temp;
	}

	public MyLinkedList(){

	}
	public int getLength(){
		int size=0;
		Node temp=head;
		while(temp!=null){
			temp=temp.next;
			size++;
		}
		return size;
	}

	public void add(Node obj){
		Node temp=obj;
		//System.out.println("head value: "+head);
		if(head==null){
			head=temp;
			//head.next=null;
		}
		else{
			getLast().next=temp;

		}

	}

	public void add(Node obj, int index){

		Node temp=head;
		int count=0;
		Node node=obj;
		while(temp.next!=null){
			temp=temp.next;
			count++;
			if(count==index-1)
				break;
		}
		Node tobeMoved=temp.next;
		temp.next=node;
		node.next=tobeMoved;
	}


	public Node get(int index){
		Node temp=head;
		int count=0;
		if(index>getLength()){
			throw new IndexOutOfBoundsException();
		}
		while(temp.next!=null && index!=0){
			count++;
			temp=temp.next;
			if(count==index){
				break;
			}

		}
		return temp;
	}

	public void printList(Node head){


		if(head!=null){

			Node temp=head;
			while(temp!=null && temp.next!=null){

				System.out.print(temp+", ");
				temp=temp.next;
			}
			System.out.print(temp.toString());
			System.out.println();
		}
	}
}
