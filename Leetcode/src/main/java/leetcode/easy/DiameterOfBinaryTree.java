package leetcode.easy;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/5/28.
 */
public class DiameterOfBinaryTree {

    public int diameterOfBinaryTreeI(TreeNode root) {
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        int ld = diameterOfBinaryTreeI(root.left);
        int rd = diameterOfBinaryTreeI(root.right);
        return Math.max(ld, Math.max(rd, lh+rh)) - 1;
    }

    public int height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode root){
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        //update max length on the fly.
        //compare the current max with the new path which cross current root.
        max = Math.max(max, left+right);

        return Math.max(left, right) + 1;
    }

}
