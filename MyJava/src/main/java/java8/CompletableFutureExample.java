package java8;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class CompletableFutureExample {
    private static final AtomicInteger nextId   = new AtomicInteger(0);
    ThreadLocal<Integer> threadLocal= new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue()
        {
            return nextId.getAndIncrement();
        }

    };

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFutureExample example = new CompletableFutureExample();
        // chain example
        example.exampleOp();

    }
    public void exampleOp() throws InterruptedException, ExecutionException {
        // block and wait for the result
        // CompletableFuture allows you to build pipeline executed
        // asynchronously within the ForkJoinPool
        CompletableFuture<?> cf = CompletableFuture.supplyAsync(this::createId).thenApply(this::convert)
                .thenAccept(this::store);
        //System.out.println("null : " + cf.get());
    }


    private UUID createId() {
        return UUID.randomUUID();
    }
    private String convert(UUID input) {
        return input.toString();
    }

    private void store(String message) {
        System.out.println("message : " + message);
    }

}
