package leetcode.Linkedin;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/8/1.
 */
public class BinaryTreeUpsideDown2 {
    /**
     *  Based on question statement,
     *  right node either leaf with sibling, or empty.
     *  new root will always be left most node.
     * */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null)
            return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        //since every level we have reference to root.
        //so we modify based on root.
        //if we modify based on newRoot. when we pop up, newRoot will change at each level, result will mess up
        //but root is local at each level, so we use root to change pointers at each recursion
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
