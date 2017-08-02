package leetcode.easy;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2016/4/6.
 */
public class LowestCommonAncestor {

    /**
    *  Solution for regular binary tree, not binary search tree
    * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){

        if(root == null)
            return root;
        else if(isUnderNode(root.left, p) && isUnderNode(root.left, q))
            return lowestCommonAncestor(root.left, p, q);
        else if(isUnderNode(root.right, p) && isUnderNode(root.right, q))
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }

    /**
     * Solution for binary search tree
     * */
    public TreeNode lowestCommonAncestorForBST(TreeNode root, TreeNode p, TreeNode q){
        if(p.val == root.val || q.val == root.val)
            return root;
        else if(max(p.val, q.val) < root.val)
            return lowestCommonAncestorForBST(root.left, p, q);
        else if(min(p.val, q.val) > root.val)
            return lowestCommonAncestorForBST(root.right, p, q);
        else
            return root;
    }

    public int max(int a, int b){
        return a > b ? a : b;
    }

    public int min(int a, int b){
        return a > b ? b : a;
    }

    private boolean isUnderNode(TreeNode parent, TreeNode child){
        if(parent == null)
            return false;
        else if(parent.val == child.val)
            return true;
        else
            return isUnderNode(parent.left, child) || isUnderNode(parent.right, child);
    }

}
