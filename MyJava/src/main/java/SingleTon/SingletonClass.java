package SingleTon;

public class SingletonClass {
	 static SingletonClass singletonClass=null;//remove the static and see the compilor error
	private SingletonClass(){ //constructor should be private so that other classes can not create this objectR
	
	}
	  static SingletonClass getInstance(){
		if(singletonClass==null){
			singletonClass= new SingletonClass();
		}
		return singletonClass;
	}

	public void m1(){
		try {
			Thread.sleep(3000);

			System.out.println("method-1"+Thread.currentThread().getId());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void m2(){
		try {
			Thread.sleep(3000);
			System.out.println("method-2"+Thread.currentThread().getId());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
