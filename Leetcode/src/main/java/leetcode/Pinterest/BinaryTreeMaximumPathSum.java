package leetcode.Pinterest;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/6/20.
 */
public class BinaryTreeMaximumPathSum {

    int max = Integer.MIN_VALUE;
    public int maxSum(TreeNode root){
        getMax(root);
        return max;
    }

    public int getMax(TreeNode root){
        if(root == null) return 0;
        int leftMax = getMax(root.left);
        int rightMax = getMax(root.right);
        //left and right may be both negative, so that root.val will be the maximum in this subTree.
        int localMax = Math.max(Math.max(leftMax, rightMax) + root.val, root.val);
        //we keep updating global max. since global max allow left -> root -> right route. So we also consider this.
        max = Math.max(Math.max(max, localMax), leftMax + rightMax + root.val);
        //localMax only hold the maximum value from leaf to current root.
        //so when you recursion up, it is always one route.
        return localMax;
    }
}
