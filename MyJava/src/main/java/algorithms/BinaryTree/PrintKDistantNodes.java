package algorithms.BinaryTree;

import algorithms.TreeNode;

/**
 * @author evarapp
 * 
 * Understanding the recursion technique is the trick here
 *
 */
public class PrintKDistantNodes {
	static int k=2;
	public static void main(String[] args) {
		BinaryTree.createBinaryTree();
		TreeNode rootNode=BinaryTree.getRootNode();
		printKDistant(rootNode, 0);
		//System.out.println("Level Order traversal of binary tree will be:");  
	}
	
	 static void printKDistant(TreeNode node, int level) {
	        if (node == null) {
	            return;
	        }
	        //This is the place whre we have reached height k. So printing the nodes and returning
	        if (k == level) { // this is the very important condition
	            System.out.print(node.data + " ");
	            return;
	        } else {
	            printKDistant(node.left, level+1);
	            //printKDistant(node.right, k);
	            printKDistant(node.right, level+1);
	            //printKDistant(node.left, k);
	            
	        }
	    }
	 
	
}
