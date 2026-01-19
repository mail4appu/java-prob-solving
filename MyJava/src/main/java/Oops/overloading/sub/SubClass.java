package Oops.overloading.sub;

import Oops.overloading.sup.SuperClass;


public class SubClass extends SuperClass{
	
	private void run(){
		System.out.println("Child is running");
	}
	public void talk(Object lang){
		System.out.println("child is talking"+lang);
	}
	
	public void talk(String lang){
		System.out.println("child overlaod is talking: "+lang);
	}

}
