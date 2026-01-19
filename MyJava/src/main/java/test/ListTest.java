package test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<String> al= new ArrayList<String>();
		al.add("./splash-install");
		al.add("sudo");
		System.out.println("non existing");
		for(String s:al){
			if(s.contains("splash")){
				System.out.println("exists");
			}
		}
		
	}
}
