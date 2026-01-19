package Practice;

import Collections_FrmWrk.implementations.linkedList.MyLinkedList;
import Collections_FrmWrk.implementations.linkedList.Node;
import algorithms.linkedlist.LinkedListUtil;

import java.util.Scanner;

public class KthNodeFromEnd {
    public static void main(String[] args) {
        System.out.println("Please enter position to find node at");
        Scanner sc= new Scanner(System.in);
        int position=sc.nextInt();
        sc.nextLine();
        MyLinkedList myLinkedList = LinkedListUtil.prepareLinkedList();
        myLinkedList.printList(myLinkedList.get(0));

        findKthNode(myLinkedList.get(0), position);
    }

    private static int findKthNode(Node node, int position) {
        if(node.next==null){
            return 1;

        }
        int count=findKthNode(node.next, position)+1;
        if(count==position){
            System.out.println("Node at position "+position+" is : "+node.data);
        }
        return count;
    }
}
