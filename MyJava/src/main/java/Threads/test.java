package Threads;

public class test {
	static int count=0;
	public static void main(String[] args) throws Exception {
		
		System.out.println("acb".equals(null));
		
		Thread t1= new Thread() {
			@Override
			public void run() {
			for(int i=0; i<1000;i++){
				count++;
			}
			}
			
			
		};
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("count is"+count);
	
		
	}
	
	

}
