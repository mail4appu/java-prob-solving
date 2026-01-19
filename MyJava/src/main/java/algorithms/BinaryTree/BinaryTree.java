package algorithms.BinaryTree;

import algorithms.TreeNode;

/**
 * @author Test
 *
 *
 *                     (40)
 *                    /    \
 *                (20)     (60)
 *               /   \     /  \ 
 *            (10)  (25) (50) (70)
 *                  
 *                  
 *    TreeNode is like Node in java   
 *                  
 *                  
 *                  
 *  Binary tree is  a tree in which each node has utmost two nodes
 *  
 *  Full binary tree is a tree in which each node has either zero or two nodes
 *                  
 *                  
 *                  
 */
public class BinaryTree {
	static TreeNode rootNode=null;

	public static void createBinaryTree()  
	{  

		rootNode =new TreeNode(40);  
		TreeNode node20=new TreeNode(20);  
		TreeNode node10=new TreeNode(10);  
		TreeNode node25=new TreeNode(25);  
		TreeNode node60=new TreeNode(60);  
		TreeNode node50=new TreeNode(50);  
		TreeNode node70=new TreeNode(70);  

		rootNode.left=node20;  
		rootNode.right=node60;  

		node20.left=node10;  
		node20.right=node25;  

		node60.left=node50;  
		node60.right=node70;  

	}  


	public static TreeNode getRootNode(){
		return rootNode;
	}

}
