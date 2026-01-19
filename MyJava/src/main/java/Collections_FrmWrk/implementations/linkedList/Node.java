package Collections_FrmWrk.implementations.linkedList;


/**
 * @author Test
 * 
 * When we create a node object, its next always points to nothing
 * 
 * keep this.next as null always
 *
 */
public class Node {
	public int data;
	public Node   next;

	public Node(int obj){
		this.data=obj;
		this.next=null;

	}
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb= new StringBuilder();
		sb.append(String.valueOf(data));
		return sb.toString();
	}
	

}
