package algorithms.linkedlist;

import Collections_FrmWrk.implementations.linkedList.MyLinkedList;
import Collections_FrmWrk.implementations.linkedList.Node;

/**
 *
 */
public class ReverseLinedListBetweenIndexes {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(30));
        list.add(new Node(40));
        list.add(new Node(50));
        list.add(new Node(60));
        list.add(new Node(70));
        list.printList(list.get(0));

        list.printList(reverseBetween(list.get(0), 2, 5));
    }


    public static Node reverseBetween(Node head, int left, int right) {
        int counter=0;

       Node nbs= getNodeBeforeSublist(left,head);
       Node current =nbs.next;
       nbs.next=null;
       Node prv=null;
       Node dummy=current;
       while(current!=null & counter<=(right-left)){
           Node temp=current.next;
           current.next=prv;
           prv=current;
           current=temp;
           counter++;

       }
       nbs.next=prv;
       dummy.next=current;
       return head;


    }

    private static Node getNodeBeforeSublist(int left, Node head) {
        Node nbs=null;
        int pos=0;
        if(left!=1) {
            nbs = head;
            while (pos < left-1) {
                nbs = nbs.next;
                pos++;
            }

        }
        return nbs;
    }


}
