package algorithms;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author evarapp
 * time complexity is o(n)
 * 
 *
 */
public class NextGreaterElementInArray {
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter size of array");
		int n=sc.nextInt();sc.nextLine();
		System.out.println("please enter array elements");
		int nos[]= new int[n];
		for(int i=0;i<n;i++){
			nos[i]=sc.nextInt();
		}
		sc.nextLine();
		nextGreaterElement(nos);

	}

	private static void nextGreaterElement(int[] nos) {
		Stack<Integer> numberStack=		new Stack<Integer>();
		for(int i=0;i<nos.length;i++){
			int curr=nos[i];
			while (!numberStack.empty() && curr >numberStack.peek())
			{
				System.out.println("for "+numberStack.peek()+" greater element is "+curr);
				numberStack.pop();		
			}

			numberStack.push(curr); 
		}
		while(!numberStack.isEmpty()){
			System.out.println(numberStack.pop()+" : -1");
		}
	}

}
