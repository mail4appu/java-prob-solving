
package algorithms.BinaryTree;

import algorithms.TreeNode;

public class DepthOfBinary {
	public static void main(String[] args) {
		BinaryTree.createBinaryTree();
		TreeNode rootNode=BinaryTree.getRootNode();

		System.out.println("Depth of the given binary treee is:");  
		System.out.println(depth(rootNode));  
	}

	private static int depth(TreeNode rootNode) {
     
		if(rootNode==null){
			return 0;
		}
			int ldepth=depth(rootNode.left);
			int rdepth=depth(rootNode.right);
		    return Math.max(ldepth, rdepth)+1;
			
	}
}
