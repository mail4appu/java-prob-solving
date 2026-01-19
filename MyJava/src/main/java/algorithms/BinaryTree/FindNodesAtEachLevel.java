
package algorithms.BinaryTree;

import algorithms.TreeNode;

/**
 * @author evarapp
 * 
 * 
 * This can be done recursively or iteratively using BFS algorithm
 *
 *Below is the recursive solution
 */
public class FindNodesAtEachLevel {
	public static void main(String[] args) {
		BinaryTree.createBinaryTree();
		findNodeAtEachLevel(BinaryTree.getRootNode(), 0);
	}

	private static void findNodeAtEachLevel(TreeNode rootNode, int level) {
		if(rootNode!=null){
			System.out.println(rootNode.data+" is present at level: "+level);
			findNodeAtEachLevel(rootNode.left, level+1);
			findNodeAtEachLevel(rootNode.right, level+1);
		}
		
		
		return ;
	}

}
