package Oops.constructor;

public class Child extends Parent {
	static String s="";
	public Child(int i){
		s=s+"alpha";
	}
	@Override
	public void display() {
		System.out.println("in child display");
	}
	
	public void show(){
		System.out.println("child show");
	}

}
