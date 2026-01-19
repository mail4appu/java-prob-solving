package java8;

@FunctionalInterface
public interface JAVA8Interface {
    public abstract void doWork();
    default  void sayHellow(){
        System.out.println("This is to say hello");
    }
    default void runFast(){
        System.out.println("This is to run fast");
    }
    default void ruSlow(){
        System.out.println("This is to run slow ");
    }
}
