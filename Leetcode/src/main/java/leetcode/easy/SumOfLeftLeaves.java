package leetcode.easy;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/5/25.
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        int[] result = new int[1];
        sum(root, result, "right");
        return result[0];
    }

    public void sum(TreeNode root, int[] result, String direction) {
        if (root == null) return;
        if (root.left == null && root.right == null && direction == "left") {
            result[0] += root.val;
            return;
        }
        sum(root.left, result, "left");
        sum(root.right, result, "right");
    }

}
