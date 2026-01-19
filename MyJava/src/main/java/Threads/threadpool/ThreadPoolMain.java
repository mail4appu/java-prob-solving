package Threads.threadpool;

/**
 * @author evarapp
 * 
 * Understanding thread pools:
 * http://www.ibm.com/developerworks/library/j-jtp0730/
 * http://geekrai.blogspot.in/2014/12/implementing-thread-pool-in-java.html
 *
 */
public class ThreadPoolMain {
	public static void main(String[] args) {
		try{
			ThreadPool pool= new ThreadPool(3);
			Task job1= new Task(1, 100);
			Task job2= new Task(100, 200);
			Task job3= new Task(200, 300);
			Task job4= new Task(300, 400);
			Task job5= new Task(400, 500);
			Task job6= new Task(500, 600);
			Task job7= new Task(600, 700);
			pool.submit(job1);
			pool.submit(job2);
			pool.submit(job3);
			pool.submit(job4);
			pool.submit(job5);
			pool.submit(job6);
			pool.submit(job7);
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}


	}
}
