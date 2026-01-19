package Threads.interrupts;

import java.util.concurrent.CountDownLatch;

public class MyCountDownLatch extends CountDownLatch {

    boolean isAborted;
    /**
     * Constructs a {@code CountDownLatch} initialized with the given count.
     *
     * @param count the number of times {@link #countDown} must be invoked
     *              before threads can pass through {@link #await}
     * @throws IllegalArgumentException if {@code count} is negative
     */
    public MyCountDownLatch(int count) {
        super(count);
    }


    public boolean isAborted() {
        return isAborted;
    }

    public void setAborted(boolean aborted) {
        isAborted = aborted;
    }

    @Override
    public void await() throws InterruptedException {
        if(!isAborted())
        super.await();
    }
}
