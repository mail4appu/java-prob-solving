package Threads;

public class MultiThreading_Example2 extends Thread{
	public void run()   
    {
        for(int i = 9; i >= 0;  i--)   
        {
	   System.out.println("Test2: " + i);
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

public void calculate(){
    for(int i = 9; i >= 0;  i--)   
    {
   System.out.println("Test2: " + i);
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
