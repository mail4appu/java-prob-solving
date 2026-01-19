package Practice;

import Collections_FrmWrk.implementations.linkedList.MyLinkedList;
import Collections_FrmWrk.implementations.linkedList.Node;
import algorithms.linkedlist.LinkedListUtil;

/**
 * Here we dont need to return everything
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = LinkedListUtil.prepareLinkedList();
        myLinkedList.printList(myLinkedList.get(0));
        reverseUsingRecursion(myLinkedList.get(0));
    }

    private static void reverseUsingRecursion(Node rootNode) {

        Node temp=rootNode;
        if(temp.next==null){
            System.out.println(temp.data);
            return;
        }
        reverseUsingRecursion(temp.next);
        System.out.println(rootNode.data);
        rootNode.next.next=rootNode;
        rootNode.next=null;

        return;


    }
}
