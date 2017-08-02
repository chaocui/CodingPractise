package leetcode.Facebook;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/5/31.
 */
public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        /**
         * basically,
         * 1. if a nodes' in order successor is null, and if this node is in left sub tree,
         *    its successor should be the left sub trees root.
         * 2. but if it is in right subtree, if it is null, then it is null. since right will get traversed last in
         *    an in-order traversal.
         *
         * if p.val >= root.val, we go right.
         * this means that at the point we find the node(the equal condition) we still go right, then
         * the next recursion, if there are still right sub tree, we will go left for sure.
         * So either we get null or we go left and get a node back.
         * */
        if(p.val >= root.val) return inorderSuccessor(root.right, p);
        else{
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
    }

}
