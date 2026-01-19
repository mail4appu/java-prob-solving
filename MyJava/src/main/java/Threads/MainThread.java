package Threads;

import java.util.ArrayList;

public class MainThread {
	public static void main(String[] args) {
		ArrayList<Integer> list= new ArrayList<Integer>(10000);
		for(int i=0; i<1000;i++){
			list.add(i);
			
		}
        getSum(list);
}
	public static int getSum(ArrayList<Integer> list){
		
		
		
		return 1;
	}	
}

