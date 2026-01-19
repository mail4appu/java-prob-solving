package Threads.Thread_Synch;

public class TableThreadMain {
	public static void main(String args[]){
		
		Table obj = new Table();//only one object
		TableThread1 t1=new TableThread1(obj);
		TableThread2 t2=new TableThread2(obj);
		t1.start();
		t2.start();
		try{
		//t1.join();//means, the code after this line will not be executed until t1 is done with its work.
		}catch(Exception ex){
			
		}
		System.out.println("finished");
		}

}

