package Threads.Thread_Synch;

public class TableThread2 extends Thread{
	Table t;
	TableThread2(Table t){
	this.t=t;
	}
	public void run(){
	t.printTable(100);
	}

}
