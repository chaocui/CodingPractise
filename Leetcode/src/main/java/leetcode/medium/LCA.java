package leetcode.medium;

import leetcode.util.TreeNode;

public class LCA {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	//if root is either p or q, means that the other node is under root. so lowest will be root.
    	//return root.
    	if(root == null || root == p || root == q) return root;
    	//otherwise
    	//iterate to left and right
    	//basically if left and right both not null, means left and right hold one of them at each side.
    	//result will be root.
    	//If left is null, means all p, q are at right, so return right.
    	//if right is null, means all p, q are at left, so return left.
    	TreeNode left = lowestCommonAncestor(root.left, p, q);
    	TreeNode right = lowestCommonAncestor(root.right, p, q);
    	//if either of them is null, return the other one, otherwise return root
    	if(left != null && right != null) return root;
    	return left != null ? left : right;
    }
}
