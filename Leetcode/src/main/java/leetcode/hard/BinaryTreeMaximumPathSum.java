package leetcode.hard;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2016/11/7.
 */
public class BinaryTreeMaximumPathSum {
    //Pass in global, update global all in every recursion
    //But in every recursion, we return only left or right max(including root itself)
    //The reason is path can only be left path -> root -> right path. Cannot be on one side, there are two branches of one node.
    public int maxPathSum(TreeNode root) {

        int result[] = new int[1];
        result[0] = Integer.MIN_VALUE;
        maxSum(root, result);
        return result[0];
    }

    public int maxSum(TreeNode root, int[] result){
        if(root == null){
            return 0;
        }
        int leftMax = maxSum(root.left, result);
        int rightMax = maxSum(root.right, result);
        int localResult = Math.max(Math.max(leftMax, rightMax) + root.val, root.val);
        result[0] = Math.max(Math.max(result[0], localResult), leftMax + rightMax + root.val);
        return localResult;
    }
}
