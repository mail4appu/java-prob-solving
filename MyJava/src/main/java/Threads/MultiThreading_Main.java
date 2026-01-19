package Threads;

public class MultiThreading_Main {
	public static void main(String args[])  
    {
		MultiThreading_Example1 t1  = new MultiThreading_Example1();     
		MultiThreading_Example2 t2  = new MultiThreading_Example2(); 
		/*t1.calculate();
		t2.calculate();*/
		t1.run();
       t1.start();

       try    
       {   
          t1.join(); 
          t2.start();   
          t2.join();    
       }        				 
       catch( InterruptedException e )  
       { 
           e.printStackTrace(); 
       }
  }    

}
