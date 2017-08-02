package leetcode.medium;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/7/13.
 */
public class BinaryTreeUpsideDown {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null)
            return root;
        //result is the new root
        //root is parent of result
        TreeNode result = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return result;
    }

}
