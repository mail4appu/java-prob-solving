package algorithms.linkedlist;

import Collections_FrmWrk.implementations.linkedList.MyLinkedList;
import Collections_FrmWrk.implementations.linkedList.Node;

public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
        MyLinkedList ml1= new MyLinkedList();
        ml1.add(new Node(1));
        ml1.add(new Node(2));
        ml1.add(new Node(4));
        MyLinkedList ml2= new MyLinkedList();
        ml2.add(new Node(1));
        ml2.add(new Node(3));
        ml2.add(new Node(4));
        merge(ml1, ml2);

    }

    private static void merge(MyLinkedList ml1, MyLinkedList ml2) {
        Node p1=ml1.get(0);
        Node p2=ml2.get(0);
        MyLinkedList returnHead=null;
        if(p1.getData()<=p2.getData()){
            returnHead=ml1;
        }
        else{
            returnHead=ml2;
        }
        while(p1!=null && p2!=null){
            if(p1.getData()<=p2.getData()){
                Node tmp=p1.next;
                p1.next=p2;
                p1=tmp;
            }else{
                Node tmp=p2.next;
                p2.next=p1;
                p2=tmp;
            }
        }
        returnHead.printList(returnHead.get(0));

    }

}
