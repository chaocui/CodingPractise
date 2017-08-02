package leetcode.medium;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2016/7/24.
 */
public class ValidateBinarySearchTree {

    //1. In order to deal with max and min integer, need initial max and min be long type
    //2. Pass in interval to check each node. min & max
    // No matter left or right, has to be in interval, otherwise not valid.
    public boolean isValidBST(TreeNode root) {
        return isBST(root, (long)Integer.MAX_VALUE + 1, (long)Integer.MIN_VALUE - 1, true);
    }

    private boolean isBST(TreeNode root, long max, long min, boolean first){
        if(root == null){
            return true;
        }

        if(!first && (root.val >= max || root.val <= min)){
            return false;
        }

        boolean isLeftValid = isBST(root.left, root.val , min, false);
        boolean isRightValid = isBST(root.right, max , root.val, false);
        return isLeftValid && isRightValid;
    }
}
