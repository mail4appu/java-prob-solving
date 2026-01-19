package algorithms.linkedlist;

import Collections_FrmWrk.implementations.linkedList.MyLinkedList;
import Collections_FrmWrk.implementations.linkedList.Node;

public class ReverseLinkedListIteratively {

    static MyLinkedList list=LinkedListUtil.prepareLinkedList();

    public static void main(String[] args) {
        reverseLinkedList(list.get(0));
    }

    private static void reverseLinkedList(Node node) {

        Node prv=null;
        Node current=node;
        while(current!=null){
            Node temp=current.next;

            current.next=prv;
            prv=current;
            current=temp;

        }
        System.out.println(prv);

    }
}
