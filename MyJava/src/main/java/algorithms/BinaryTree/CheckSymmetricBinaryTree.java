package algorithms.BinaryTree;

import algorithms.TreeNode;

public class CheckSymmetricBinaryTree {

	public static void main(String[] args) {
		SymmetricBinaryTree.createBinaryTree();
		TreeNode rootNode=BinaryTree.getRootNode();

		System.out.println("Level Order traversal of binary tree will be:");  
		System.out.println(isSymmetric(rootNode, rootNode));
	}
	private static boolean isSymmetric(TreeNode node1, TreeNode node2){
		
		if(node1==null && node2==null){
			return true;
		}
		
		if(node1!=null && node2!=null && node1.data==node2.data){
		return (isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left));
		}
		return false;

	}

}
