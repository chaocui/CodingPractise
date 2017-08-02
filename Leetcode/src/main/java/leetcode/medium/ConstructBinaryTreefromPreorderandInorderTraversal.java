package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import leetcode.util.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	//!!! Key point separate the start and end index of inorder and preorder.
	//Since preorder interval is used to find root 
	//inorder interval is used to reconstruct left and right tree based on root found from pre/post order.
	
	//Post/pre order determines which one is the root,
	//In orders used to reconstruct tree separate left and right subtree.
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> positions = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++)
        	positions.put(inorder[i], i);
        
        return build(0, inorder.length - 1, preorder, 0, inorder.length - 1, inorder, positions);
        
    }
	
	private TreeNode build(int ps, int pe, int[] preorder, int is, int ie, int[] inorder, Map<Integer, Integer> positions){
		if(ps > pe || is > ie) return null;
		int rootVal = preorder[ps];
		int rootPosition = positions.get(rootVal);
		TreeNode root = new TreeNode(rootVal);
		
		TreeNode left = build(ps+1, ps+rootPosition-is, preorder, is, rootPosition - 1, inorder, positions);
		TreeNode right = build(ps+rootPosition-is +1, pe, preorder, rootPosition+1, ie, inorder, positions);
		
		root.left = left;
		root.right = right;
		
		return root;
		
	}
	
	
}
