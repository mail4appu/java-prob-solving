package algorithms.BinaryTree;

import algorithms.TreeNode;

/**
 * @author evarapp
 * 
 *                     (40)
 *                    /    \
 *                (20)     (60)
 *               /   \     /  \ 
 *            (10)  (25) (50) (70)
 *            
 *        Output: 10 25 20 50 70 60 40
 * 
 * 
 * 
 * 
 *
 */
public class PostOrderTraversal {
	public static void main(String[] args) {
		BinaryTree.createBinaryTree();
		TreeNode rootNode=BinaryTree.getRootNode();

		System.out.println("Post Order traversal of binary tree will be:");  
		postOrderTraversal(rootNode);  
	}

	static void  postOrderTraversal(TreeNode node){

		if(node==null){
			return ;
		}
		
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print("\t "+node.data);
	}
}
