package Threads;

public class MultiThreading_Example1 extends Thread {
	public void run()   
    {
       for(int i = 0; i < 10;  i ++)   
       {
	 System.out.println("Test1: " + i);
	 try  
         {
	        Thread.sleep(1000);
         }
	 catch(InterruptedException e)  
         { 
            e.printStackTrace();  
         }
       }    
     }   

	public void calculate(){
	    for(int i = 9; i >= 0;  i--)   
	    {
	   System.out.println("Test1: " + i);
	   try  
	       {
	      Thread.sleep(2000);
	   }
	   catch( InterruptedException e )  
	       { 
	           e.printStackTrace();  
	       }
	    }     
	 
	}
		
}
