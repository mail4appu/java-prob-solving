package SingleTon;

public class MainClass {
	
	public static void main(String args[]){
		System.out.println("Executing threads");
		new Thread(()->SingletonClass.getInstance().m1()).start();
		new Thread(()->SingletonClass.getInstance().m1()).start();

	}

}
