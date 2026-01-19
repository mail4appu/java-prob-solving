package algorithms.BinaryTree;

import algorithms.TreeNode;

/**
 * @author evarapp
 * 
 * Min depth is shortest distance to a leafnode.
 * Time complexity o(n)
 *
 */
public class MinDepthOfBinaryTree {
	public static void main(String[] args) {
		BinaryTree.createBinaryTree();
		TreeNode rootNode=BinaryTree.getRootNode();

		System.out.println("Min Depth of the given binary treee is:");  
		System.out.println(minDepth(rootNode));  
	}

	private static int minDepth(TreeNode rootNode) {
		if(rootNode==null)
			return 0;
		//checking whether its a leaf node or not
		if(rootNode.left==null  && rootNode.right==null){
			return 1;
		}
		int ldepth= minDepth(rootNode.left);
		int rdepth= minDepth(rootNode.right);
		return Math.min(ldepth, rdepth)+1;
	}

}
