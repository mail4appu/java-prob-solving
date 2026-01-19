package algorithms.linkedlist;

import Collections_FrmWrk.implementations.linkedList.MyLinkedList;
import Collections_FrmWrk.implementations.linkedList.Node;

public class LinkedListMain {
    public static void main(String[] args) {
        int a =5;
        String s=new String("123");
        System.out.println(s);
        Integer i= new Integer(50);
        System.out.println(i);
        System.out.println(a);
        MyLinkedList myLinkedList = LinkedListUtil.prepareLinkedList();
        Node head = myLinkedList.get(0);
        System.out.println(System.identityHashCode(head));
        System.out.println(head);
        System.out.println(System.identityHashCode(head.next));


    }
}
