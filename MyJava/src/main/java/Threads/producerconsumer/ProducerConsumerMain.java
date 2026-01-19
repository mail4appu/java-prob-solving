package Threads.producerconsumer;

public class ProducerConsumerMain {

    public static void main(String[] args) {
        CustomBlockingQueue<Integer> blockingQueue = new CustomBlockingQueue<Integer>(10);

        Runnable producerTask = () -> {
            for (int i = 0; i < 10; i++) {
                blockingQueue.put(i);
            }
        };
        Runnable consumerTask = () -> {
            for (int i = 0; i < 10; i++) {
                blockingQueue.take();
            }
        };

        Thread producer = new Thread(producerTask);
        producer.start();
        Thread producer2 = new Thread(producerTask);
        producer2.start();

        Thread consumer = new Thread(consumerTask);
        consumer.start();
        Thread consumer2 = new Thread(consumerTask);
        consumer2.start();


    }
}
