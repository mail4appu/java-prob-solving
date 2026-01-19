package Hashing;

public class HashingExample {
	int index=0;
	public HashingExample(){
	}
	public void add(Object ob){
		ob=new Object();
		index=ob.hashCode();
		
		System.out.println("index is"+index);
		
	}
	
	

}
