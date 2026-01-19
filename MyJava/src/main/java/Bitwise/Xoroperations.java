package Bitwise;

public class Xoroperations {
	public static void main(String[] args) {
		int []input={1,2,3,4,5,6,7,8,9};
		for(int i=0;i<input.length-1;i++){
			System.out.println(input[i]+"^"+input[i+1]+" = "+(input[i]^input[i+1]));
		}
		
		System.out.println(1<<2);//1*(2^2)
		System.out.println(3<<2);//3*(2^2)
		System.out.println(5<<3);//5*(2^3)
		System.out.println(48>>3);//48/(2^3)
		
		System.out.println(Integer.toBinaryString(13^17));
		printDuplicate();
	}
	
	private static void printDuplicate(){
		int[] input= new int[]{4,4,5,6,7,8};
		int xorRes=0;
		for(int i=1;i<=(input.length-1);i++){
			xorRes=xorRes^i;
		}
		System.out.println("xor result"+xorRes);
		for(int i:input){
			xorRes=xorRes^i;
		}
		
		System.out.println("duplicate is"+xorRes);
		
		
		
		
	}
	
	

}
