package algorithms.BinaryTree;

import algorithms.TreeNode;

/**
 * @author evarapp
 * 
 * Full binary tree is a binary tree in which all nodes must have either zero or two nodes.
 *
 */
public class FullBinaryTree {
	public static void main(String[] args) {
		BinaryTree bt= new BinaryTree();
		@SuppressWarnings("static-access")
		TreeNode  rootNode=bt.getRootNode();
		System.out.println(isFullBinaryTree(rootNode));
	}

	private static boolean isFullBinaryTree(TreeNode rootNode) {
		//if node is null
		if(rootNode==null)
			return true;
		//node is there but left and right nodes are null
		if(rootNode.left ==null && rootNode.right==null)
			return true;
		//left and right nodes are not null, so these nodes should also be full  binary trees
		if(rootNode.left!=null && rootNode.right!=null){
			return  isFullBinaryTree(rootNode.left) && isFullBinaryTree(rootNode.right);
		}
					
        return false;
	}
}
