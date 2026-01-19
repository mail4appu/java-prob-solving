package java8;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {
    public static void main(String[] args) {
        CompletableFutureTest completableFutureTest = new CompletableFutureTest();
        completableFutureTest.testCompletableFuture();
        System.out.println("Finished main Thread ");
    }

    public void testCompletableFuture() {
        CompletableFuture.runAsync(this::haveSoundSleep).thenRun(this::calculate);

    }

    private String haveSoundSleep() {
        try {
            Thread.sleep(30000);
            System.out.println("Sleeping nicely");
            return "Waking after sound sleep";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "";
        }
    }


    private String calculate() {
        System.out.println("Applied successfully after having sound sleep");
        return "applied successfully ";

    }
}
