package algorithms.BinaryTree;

import algorithms.TreeNode;

public class SymmetricBinaryTree {

	
	static TreeNode rootNode=null;

	 public static void createBinaryTree()  
	 {  
	    
	  rootNode =new TreeNode(40);  
	  TreeNode node1=new TreeNode(2);  
	  TreeNode node2=new TreeNode(2);  
	  TreeNode node3=new TreeNode(3);  
	  TreeNode node4=new TreeNode(4);  
	  TreeNode node5=new TreeNode(4);  
	  TreeNode node6=new TreeNode(3);  
	    
	  rootNode.left=node1;  
	  rootNode.right=node2;  
	    
	  node1.left=node3;  
	  node1.right=node4;  
	    
	  node2.left=node5;  
	  node2.right=node6;  
	    
	 }  

	 
	 public static TreeNode getRootNode(){
		 return rootNode;
	 }

}
