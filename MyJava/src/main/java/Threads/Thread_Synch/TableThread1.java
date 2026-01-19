package Threads.Thread_Synch;

public class TableThread1  extends Thread{
	Table t;
	TableThread1(Table t){
	this.t=t;
	}
	public void  run(){
	t.printTable(5);
	}

}
