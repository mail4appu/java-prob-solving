package algorithms.linkedlist;

import Collections_FrmWrk.implementations.linkedList.MyLinkedList;
import Collections_FrmWrk.implementations.linkedList.Node;

/**
 * This also works on faith & expectation analogy
 *
 * Faith= reverseInKSize() gives reversed linked list in k groups
 * Expectation :  After initial k number of nodes, reverseInKSize() knows how to reverse in k groups
 *                and return pointer to reversed list
 *
 *  Meeting Faith & Expectation
 *
 *  Reverse first K nodes & point its head.next to above expectation
 *  Finally return prv, that holds pointer to the entire reversed list
 *
 */
public class ReverseLinkedListInKGroups {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(30));
        list.add(new Node(40));
        list.add(new Node(50));
      /*  list.add(6);
        list.add(7);*/
        list.printList(list.get(0));

        list.printList(reverseInKSize(list.get(0), 3));

    }

    private static Node reverseInKSize(Node head, int k ) {

        int pos=1;
        Node prv=null;
        Node current=head;

        int c=0;
        //This code is for not reversing a group that has size less than k
        Node dummy=current;
        while(dummy!=null && c<k){
            dummy=dummy.next;
            c++;

        }
        if(c<k){
            return current;
        }
        //Above code is for not reversing a group that has size less than k

        while(pos<=k && current!=null){
            Node tmp=current.next;
            current.next=prv;
            prv=current;
            current=tmp;
            pos++;
        }
        if(current!=null)
            head.next=reverseInKSize(current,k);

        return prv;

    }


}
