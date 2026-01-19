package Threads.ThreadScheduling;

public class ThreadDemo extends Thread{
	
	 public void run() 
	  {
	    int k = 0;
	    try{
	    synchronized(this){//object.wait() or Thread.sleep() wil cause context switching i.e shifting the 
	    	//execution from one thread to another thread
	    for (int i = 0; i < 10; i++)
	    {
	      k++; 
	      k--; 
	     
	    	  Thread.sleep(1000);
	    	  //this.wait(1000);  //=> context switching. but if we add join method to thread, then context wil
	                                  //not be switched  	
	    	  System.out.println(this.getName( ) + ": "  + k);	  
	      }
	    
	    }
	    }
	 catch(Exception e){
		 
	 }
	      
	   }
	   
	    


}
