package leetcode.medium;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/5/24.
 */
public class InorderSuccessorInBST {

    /**
     * Recursively doing this.
     * 1. Since we are looking for inorder successor.
     *    if target node is in the right subtree,
     *    just return findSuccessor(root.right,. p), because inorder traversal do right subtree last.
     *    so what ever return from the right sub tree is the result also.
     *
     *    if target node is in the left subtree,
     *    findSuccessor(root.left, p), if it returns null, means that the next traversal node will be root node, so return root.
     *    otherwise, return the result we get here.
     *
     *    This is smart!
     * */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        if(p.val >= root.val) return inorderSuccessor(root.right, p);
        else{
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
    }
}
