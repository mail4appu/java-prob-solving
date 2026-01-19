package BigInt;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Test
 * 
 *
 *
 */
public class Addition {

	static int i=2147483647;
	static int a=40, b=50;
	
	public static void main(String[] args) {
		
		System.out.println();
		System.out.println(Integer.MAX_VALUE);
		
		System.out.println(Integer.MIN_VALUE);
		System.out.println(addIterative(a,b));
		Scanner sc= new Scanner(System.in);
		System.out.println("Please enter no of test cases");
		int size=sc.nextInt();
		sc.nextLine();
		System.out.println("Please enter "+size+" integers");
		String[] nos= new String[size];
		for(int i=0;i<size;i++){
			nos[i]=String.valueOf(sc.nextInt());
		}
		sc.nextLine();
		System.out.println("Entered series "+Arrays.toString(nos));
		getIntArrays(nos);
		
	}
	
	public static int addIterative(int a, int b){ 
        while (b != 0){
            int carry = (a & b) ; //CARRY is AND of two bits
          
            a = a ^b; //SUM of two bits is A XOR B
          
            b = carry << 1; //shifts carry to 1 bit to calculate sum
        }
        return a;
    }

 private static void getIntArrays(String[] nos){
	 System.out.println("Entered series length"+nos.length);
	 int[] temp;
	for(int i=0;i<nos.length;i++){
		temp=new int[nos[i].length()];
		String n=nos[i];
		System.out.println(nos[i]);
		for(int j=0;j<n.length();j++){
			//System.out.println(n.charAt(j));
			temp[j]=n.charAt(j)-48;
	}
	System.out.println(Arrays.toString(temp));	
	}
	 
 }
	
}
