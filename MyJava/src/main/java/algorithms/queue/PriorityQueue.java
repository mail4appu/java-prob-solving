package algorithms.queue;

import java.util.Iterator;
import java.util.Queue;

public class PriorityQueue {
    public static void main(String[] args) {
        Queue<String> myPriorityQueue=new java.util.PriorityQueue<>(5);
        myPriorityQueue.add("Ram");
        myPriorityQueue.add("Subbu");
        myPriorityQueue.add("Maddy");
        myPriorityQueue.add("Raja");
        myPriorityQueue.add("Bhanu");
        myPriorityQueue.add("Appu");
        myPriorityQueue.add("Suri");
        myPriorityQueue.add("Satti");
        myPriorityQueue.add("zviom");

        System.out.println(myPriorityQueue.size());
        while(myPriorityQueue.size()>5){
            myPriorityQueue.poll();
        }


        Iterator<String> iterator = myPriorityQueue.iterator();
        while(iterator.hasNext()){
            System.out.println("Normal print "+iterator.next());
        }
        while(!myPriorityQueue.isEmpty())
        System.out.println("After poll   "   +myPriorityQueue.poll());

    }
}
