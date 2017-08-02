package leetcode.medium;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/3/12.
 */
public class FlattenBinaryTreeToLinkedList {

    //Pre-order traversal
    //flatten left and right recursively.
    //then combine the flattened result.
    //check left and right see if they are null.

    //if both are not null, append left first, then get the right most and append right.
    //at the end, set root.left = null. since we already moved left tree.
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);
        if(left == null)
            root.right = right;
        else if(right == null)
            root.right = left;
        else{
            root.right = left;
            TreeNode it = left;
            while(it.right != null)
                it = it.right;
            it.right = right;
        }
        root.left = null;
    }
}
