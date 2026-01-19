package Threads.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class CustomBlockingQueue<E> {
    Queue<E> queue;
    int maxSize;

    public CustomBlockingQueue(int maxSize) {
        queue = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public void put(E element) {

        try {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    System.out.println("producers is waiting");
                    queue.wait();
                }
                queue.add(element);
                System.out.println("state with producer"+queue);
                queue.notifyAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public Object take() {


        try {
            synchronized (queue) {
                while (queue.size() == 0) {
                    System.out.println("Consumer is waiting");
                    queue.wait();
                }
                E remove = queue.remove();
                System.out.println("state with Consumer"+queue);
                queue.notifyAll();
                return remove;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
