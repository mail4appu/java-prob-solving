package algorithms.BinaryTree;

import algorithms.TreeNode;

/**
 * @author evarapp
 * Method can have constructor name where in the compiler gives just warning
 *                     (40)
 *                    /    \
 *                (20)     (60)
 *               /   \     /  \ 
 *            (10)  (25) (50) (70)
 *            
 *        Output: 10 20 25 40 50 60 70
 *                  
 * 
 * 
 */
public class InOrderTraversal {
	public static void main(String[] args) {
		BinaryTree.createBinaryTree();
		TreeNode rootNode=BinaryTree.getRootNode();

		System.out.println("In Order traversal of binary tree will be:");  
		inOrderTraversal(rootNode);  
	}

	static void  inOrderTraversal(TreeNode node){

		if(node==null){
			return ;
		}
		inOrderTraversal(node.left);
		System.out.print("\t "+node.data);
		inOrderTraversal(node.right);
	}

}
