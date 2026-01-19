package algorithms.linkedlist;

import Collections_FrmWrk.implementations.linkedList.MyLinkedList;
import Collections_FrmWrk.implementations.linkedList.Node;

/**
 *
 * Deleting "next node" is practically possible in linkedlist
 * ie. 11->5->24
 * Removing 5 is changing the pointer of 11 to 24 & changing the pointer of 5 to null
 *
 * But to remove the given node we need to use copy trick
 *
 *
 *
 */
public class RemoveAllOccurrencesOfANode {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(30));
        list.add(new Node(40));
        list.add(new Node(50));
        list.add(new Node(6));
        list.add(new Node(7));
        list.add(new Node(30));

        list.printList(list.get(0));

        list.printList(remove(list.get(0), 30));

    }

    private static Node remove(Node head, int data) {
        Node dummy = new Node(-1);
        dummy.next=head;
        Node tmp = dummy;
        while (tmp.next != null) {
            if ((Integer) tmp.next.data == data) {
                Node otherNode = tmp.next.next;
                tmp.next = otherNode;
            } else {
                tmp = tmp.next;
            }


        }
        return dummy.next;
    }
}
