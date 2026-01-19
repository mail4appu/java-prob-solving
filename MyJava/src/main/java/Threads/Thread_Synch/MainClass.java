package Threads.Thread_Synch;

public class MainClass{
	public static void main(String args[]){
	Employee_Synchronized emp1= new Employee_Synchronized();
	Employee_Synchronized emp2= new Employee_Synchronized();
	emp1.setName("firstemp");
	emp2.setName("secemp");
	emp2.start();
	emp1.start();
	
	
	
}
}
