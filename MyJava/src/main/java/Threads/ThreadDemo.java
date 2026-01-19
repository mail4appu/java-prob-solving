package Threads;

public class ThreadDemo extends Thread{
	 public  void run()        
     {
         try  
         {
        	 if(this.getName().equals("first")){
            for( int i = 0; i < 10; i++)    
            {
	       System.out.println("FirstThread: " + i );    
           Thread.sleep(1000);        
            }  
        	 }else{
        		 for( int i = 9; i > 0; i--)    
                 {
     	       System.out.println("Second Thread: " + i );    
                    Thread.sleep(1000);        
                 }  
        	 }
         }          
         catch(InterruptedException e)  
         {  
               System.err.println("Sleep time is disturbed, you may get incorrect functionality. " + e);
         }
 
         System.out.println("Successful");   
   }
    public static void main(String args[])  throws Exception  
    {
    	 
    	ThreadDemo d1 = new ThreadDemo();

    	d1.setName("first");
    	ThreadDemo d2 = new ThreadDemo();
    	d2.setName("sec");
        d1.start();
        d1.join();
        d2.start();
        //join() means creator(main thread...dat creates the instances of threads) wil wait until the child threads wil get executed
         //if u remove join main thread wil be executed first and dies. here we r makin sure parent wil not die until child dies
        
         /*d1.join(); //or t.join(3000);*/
         //d2.join();
         for(int i=0;i<3;i++)
         {
         System.out.println("main thread");
         }
     }

}
