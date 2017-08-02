package leetcode.easy;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/4/21.
 */
public class MinimumDepthOfBinaryTree {

    /**
     * Since only leaf count.
     * So if left is null, just return right min + 1
     * right is null, just return left min + 1
     * otherwise, return Math.min(left, right);
     * */
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        else if(root.left == null) return 1 + minDepth(root.right);
        else if(root.right == null) return 1 + minDepth(root.left);
        else return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }



}
