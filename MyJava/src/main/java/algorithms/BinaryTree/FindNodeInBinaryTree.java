package algorithms.BinaryTree;

import algorithms.TreeNode;

public class FindNodeInBinaryTree {
	public static void main(String[] args) {
      BinaryTree.createBinaryTree();
      System.out.println( findNodeInBinaryTree(BinaryTree.getRootNode(), 40));
	}

	private static boolean findNodeInBinaryTree(TreeNode rootNode, int keyData) {
     if(rootNode!=null){
    	 if(rootNode.data==keyData)
    		 return true;
    	 return findNodeInBinaryTree(rootNode.left, keyData) || findNodeInBinaryTree(rootNode.right, keyData);
     }
     return false;
	}
}
