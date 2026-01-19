package Threads;

public class SynchronizedDemo implements Runnable{
	static int k;                                        // value default is 0
    public void run() 
    {
    	//this=referecne to the current object
       synchronized(this)//remove this synchronized block and see the results
        {
          for(int i = 0; i < 100000; i++) 
          {
               k++;		                   // increments by one
               k--;                             // decrements by one
          }
        }
        
   }
  /*  public void calculate(int j){//here the objects are not threads, these wil be executed sequentially irrespective 
    	//of the synchronied keyword
    	synchronized(this)//remove this synchronized block and see the results
        {
          for(int i = 0; i < 100000; i++) 
          {
               k++;		                   // increments by one
               k--;                             // decrements by one
               
          }
          System.out.print("Final result"+j+":" + k+" \n"); 
       // }
    }*/
   public static void main(String[] args) throws Exception 
   {
	   SynchronizedDemo sd = new SynchronizedDemo();
	   Thread bundle[] = new Thread[100];
	 //  SynchronizedDemo[] sd = new SynchronizedDemo[100];
            
           /* for(int i=0;i<100;i++){
            	sd[i]=new SynchronizedDemo();
            	sd[i].calculate(i);
            }*/
            for(int i = 0; i < bundle.length; i++)
            {
                  bundle[i] = new Thread(sd);
                  bundle[i].start();
                  System.out.print("Final result"+i+":" + k+" \n"); 
             }
                  
   }

}
