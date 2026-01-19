package Threads;

public class Example {
	public static void main(String []args)throws Exception{
		Example ex=new Example();
		
	synchronized(ex){	
		System.out.println("in the synchronized block****************");
		   
		   ex.wait(1000);
		   ex.notify();
		    
			System.out.println("in the synchronized block");
			
		
	
	
}
}
}