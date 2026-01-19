package airamatrix;

public class LinkedListOperations {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {




    }

    public void middleNode(ListNode head) {
        ListNode slowPtr=head;
        ListNode fastPtr=head;
        while(fastPtr.next!=null){
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
        }

        if(fastPtr.next==null){
            System.out.println("Mod node is" + slowPtr.val);
        }else {
            System.out.println("Mod node is"+slowPtr.next.val);
        }


    }


}
