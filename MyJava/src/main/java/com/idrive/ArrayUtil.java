package com.idrive;

import java.util.Arrays;

public class ArrayUtil {
	public static void main(String[] args) {
		String elements[]= new String[5];
		String str="a";
		if(str.equals("a")){
			elements[0]="appu";
		}
		if(str.equals("b")){
			elements[0]="maddy";
		}
		System.out.println(Arrays.toString(elements));
	}

}
