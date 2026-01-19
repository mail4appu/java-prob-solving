package Collections_FrmWrk.implementations.linkedList;

public class LinkedListMain {
	
	public static void main(String[] args) {
		MyLinkedList list= new MyLinkedList();
		/*list.add("hi");
		list.add("bye");
		list.add("goodbye");
		list.add("great day");*/
		System.out.println(list.getLength());
		System.out.println(list.get(3).data);
		list.printList(list.get(0));
	}

}
