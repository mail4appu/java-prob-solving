package algorithms.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algorithms.TreeNode;

/**
 * @author evarapp
 * 
 *  *******Null as a delimiter for each level*********
 * 
 * Here the technique is first add rootnode and null into the queue.
 * Same technique like binary list traversal with a minor difference
 * 
 * When we poll other nodes, we add its children to queue but 
 * When we poll null, add this null back to queue as long as queue is not empty.
 * 
 * here null acts as delimiter for each level.
 * So when we come across null, we can print newline or sum up the elements from list 
 * and after summing up the list clear the list to add fresh nodes from other levels
 * 
 * 
 */
public class SumAtLevelOfBT {
	public static void main(String[] args) {
		// Creating a binary tree  
		BinaryTree.createBinaryTree();
		TreeNode rootNode=BinaryTree.getRootNode();

		System.out.println("Level Order traversal of binary tree will be:");  
		sumAtEachLevel(rootNode);
	}

	private static void sumAtEachLevel(TreeNode rootNode) {
		// TODO Auto-generated method stub
		Queue<TreeNode> queue= new LinkedList<TreeNode>();
		queue.add(rootNode);
		queue.add(null);
		List<Integer> levlList= new ArrayList<Integer>();;
		while(!queue.isEmpty()){
			TreeNode temp= queue.poll();
			if(temp==null){
				int sum=0;
				for(Integer no:levlList){
					sum=sum+no;
				}

				System.out.println(sum);
				levlList.clear();
				if(!queue.isEmpty())
					queue.add(temp);
			}
			else{
				System.out.printf("%d ",temp.data);
				levlList.add(temp.data);
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);


			}
		}

	}


}
