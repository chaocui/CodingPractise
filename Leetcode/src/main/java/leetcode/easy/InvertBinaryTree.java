package leetcode.easy;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2016/4/3.
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return root;

        else {
            TreeNode right = invertTree(root.right);
            TreeNode left = invertTree(root.left);
            root.right = left;
            root.left = right;
            return root;
        }
    }
}