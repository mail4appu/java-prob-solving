package Threads.Thread_Synch;

public class Table {
	 void  printTable(int n){//method not synchronized
		   for(int i=1;i<=100;i++){
		     System.out.println(n+"*"+i+"="+n*i);
		     try{
		     // Thread.sleep(1000);
		     }catch(Exception e){System.out.println(e);}
		   }

		 }


}
