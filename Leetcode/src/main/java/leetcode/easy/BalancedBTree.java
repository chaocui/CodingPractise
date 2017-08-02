package leetcode.easy;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2016/4/12.
 */
public class BalancedBTree {

    public boolean isBalanced(TreeNode root){
        if(root == null)
            return true;

        int heightLeft = heightOfTree(root.left);
        int heightRight = heightOfTree(root.right);

        if(Math.abs(heightLeft - heightRight) > 1)
            return false;
        else
            return isBalanced(root.left) && isBalanced(root.right);

    }

    private int heightOfTree(TreeNode node){
        if(node == null)
            return 0;
        int left = heightOfTree(node.left) + 1;
        int right = heightOfTree(node.right) + 1;
        return max(left, right);
    }

    private int max(int a, int b){
        return a > b ? a : b;
    }

}
