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
 * Explanation:
 * http://algorithms.tutorialhorizon.com/determine-whether-given-binary-tree-is-binary-search-treebst-or-not/
 * 
 *
 */
public class CheckBinarySearchTree {
	public static void main(String[] args) {
		BinaryTree.createBinaryTree();
		TreeNode rootNode=BinaryTree.getRootNode();

		System.out.println("Level Order traversal of binary tree will be:");  
		System.out.println(isValidBST(rootNode, Integer.MIN_VALUE, Integer.MAX_VALUE)); 
	}

	private static boolean isValidBST(TreeNode rootNode, int min, int max) {

		if(rootNode==null){
			return true;
		}
		if(rootNode.data<=min || rootNode.data>=max){
			return false;

		}
		return isValidBST(rootNode.left, min, rootNode.data) && isValidBST(rootNode.right, rootNode.data, max) ;

	}

}
