package algorithms.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

import algorithms.TreeNode;

/**
 * @author Test
 * 
 *   Stack and Queue are just abstractions in java.
 *   Their implementations can be done either with array or linked list
 *   
 *   Binaray List traversal in java very good site:
 *   
 *   http://www.java2blog.com/2014/08/spiralzigzag-level-order-traversal-of.html
 *   
 * 
 *
 */
public class BinaryListTraversalLevelorder {
	public static void main(String[] args) {
		// Creating a binary tree  
		BinaryTree.createBinaryTree();
		TreeNode rootNode=BinaryTree.getRootNode();
		
		System.out.println("Level Order traversal of binary tree will be:");  
		levelOrderTraversal(rootNode);  

	}
	
	public static void levelOrderTraversal(TreeNode rootNode) {  
		Queue<TreeNode> queue=new LinkedList<TreeNode>();  
		queue.add(rootNode);  
		while(!queue.isEmpty())  
		{  
			//poll() retrieves and removes the first element in the list i.e head element
			TreeNode tempNode=queue.poll();  
			System.out.printf("%d ",tempNode.data);  
			if(tempNode.left!=null)  
				queue.add(tempNode.left);  
			if(tempNode.right!=null)  
				queue.add(tempNode.right);  
		
		}  
	}  


}
