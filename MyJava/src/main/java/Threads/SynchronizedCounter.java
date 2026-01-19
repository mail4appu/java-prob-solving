package Threads;

//synchronized ==putting the events in an order
//Synchronized implies only one thread(ex: main class which instantiates the class that contains synchronized methods)
//can access the synnchronized method(ex: addition operation) ..and other programs which try to access the same have to wait
//the first thread that gets the access to the method shuld be finished first while others are waiting
public class SynchronizedCounter {
	private int c = 0;

    public   void increment() {
        c++;
    }

    public  void  decrement() {
        c--;
    }

    public  int value() {
        return c;
    }

}
