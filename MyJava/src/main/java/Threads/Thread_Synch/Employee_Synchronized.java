package Threads.Thread_Synch;

public class Employee_Synchronized extends Thread{
	public void run(){
		
		add();	
		
		
	}
	public synchronized void  add(){
	System.out.println("employee got added successfully for the thread:  "+this.getName());	
	}

}
