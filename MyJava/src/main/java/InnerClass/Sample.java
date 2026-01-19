package InnerClass;

public class Sample {
	
		public static void main(String arg[])
		{
		Thread t=new Thread()
		{
		public void run()
		{
		System.out.println("child thread job");
		}
		};
		t.start();
		System.out.println("main thread job");
		}
}
