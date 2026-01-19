package algorithms.bst;

import java.util.Scanner;



public class FindElementInBST {
	public static void main(String[] args) {
		algorithms.BinaryTree.BinaryTree.createBinaryTree();
		algorithms.TreeNode rootNode=algorithms.BinaryTree.BinaryTree.getRootNode();
		System.out.println("enter the size fo input");
		Scanner sc= new Scanner(System.in);
		int size=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter elements to be searched");
		for(int i=0;i<size;i++){
			System.out.println(isPresent(rootNode, sc.nextInt()));
		}
	}

	public static int isPresent(algorithms.TreeNode root, int val) {
		if(root==null ){
			return 0; //if element does not exist, just return 0;
		}
		else{
			if(root.data==val){
				return 1; //if element exists, just return 1;
			}
			else if(val<root.data){
				return isPresent(root.left, val);
			}
			return isPresent(root.right, val);
		}
	}

}
