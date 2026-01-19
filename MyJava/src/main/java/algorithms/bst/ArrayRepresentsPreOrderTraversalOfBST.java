package algorithms.bst;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author evarapp
 * 
 * This Class checks if a given array represents pre order traversal of a binary search tree
 * 
 * Logic to do this:
 * finding the next greater element to an array element
 * 
 *See the explanation in the following site:
 *http://javabypatel.blogspot.in/2016/01/verify-preorder-sequence-in-binary-search-tree.html 
 *
 *
 *
 *
 */
public class ArrayRepresentsPreOrderTraversalOfBST {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Please enter size of the array");
		int size= sc.nextInt();
		sc.nextLine();
		System.out.println("Please enter the elements in array");
		int []input= new int[size];
		for(int i=0;i<size;i++){
			input[i]=sc.nextInt();	
		}
		sc.nextLine();

		System.out.println(""+doesArrayRepresentPreOrderTraversalOfBST(input, size));
	}

	private static boolean doesArrayRepresentPreOrderTraversalOfBST(int[] input, int size) {
		Stack<Integer> numberStack=		new Stack<Integer>();
		int temp=Integer.MIN_VALUE;
		for(int i=0;i<input.length;i++){
			int curr=input[i];
			if(curr<temp){
				return false;
			}
			while (!numberStack.empty() && curr>numberStack.peek())
			{
                System.out.println("for "+numberStack.peek()+" greater element is "+curr);
                temp=numberStack.peek();
				numberStack.pop();		
			}

			numberStack.push(curr); 
		}



		return true;
	}

}
