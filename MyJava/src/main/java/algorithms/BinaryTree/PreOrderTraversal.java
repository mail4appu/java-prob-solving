package algorithms.BinaryTree;

import algorithms.TreeNode;

/**
 * @author evarapp
 * 
 * 
 *                     (40)
 *                    /    \
 *                (20)     (60)
 *               /   \     /  \ 
 *            (10)  (25) (50) (70)
 *            
 *        Output: 40 20 10 25 60 50 70
 * 
 * 
 *
 */
public class PreOrderTraversal {
	public static void main(String[] args) {
		BinaryTree.createBinaryTree();
		TreeNode rootNode=BinaryTree.getRootNode();

		System.out.println("pre Order traversal of binary tree will be:");  
		preOrderTraversal(rootNode);  
	}

	static void  preOrderTraversal(TreeNode node){

		if(node==null){
			return ;
		}
		System.out.print("\t "+node.data);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
}
