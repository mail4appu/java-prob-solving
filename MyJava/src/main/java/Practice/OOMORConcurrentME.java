package Practice;

import java.util.ArrayList;
import java.util.List;

/**
 * We can add as many elements as possible to ArrayList but not while traversing
 * While traversing, ConcurrentModificationException
 * While in infinite loop, Out of Memory error
 *
 * Add below jvm Parameter to have successfull JCONSOLE connections
 * -Dcom.sun.management.jmxremote=true
 *
 *
 */
public class OOMORConcurrentME {



    public static void main(String[] args) throws InterruptedException {
        List<String> strList=new ArrayList<>();
        strList.add("abc");
        strList.add("def");
        //Added this to buy some time while connecting to JCONSOLE
        Thread.sleep(20000);
       while(true){
           strList.add("appu");
       }

       //This code for ConcurrentModificationException

        /*for(String str:strList){
            strList.add(str.toUpperCase());
        }*/
    }
}
