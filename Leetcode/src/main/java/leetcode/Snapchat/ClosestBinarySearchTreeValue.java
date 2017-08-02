package leetcode.Snapchat;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/6/16.
 */
public class ClosestBinarySearchTreeValue {

    //basic idea is comparing target with root.val.
    //see we should go left or right.
    //if left or right is null, means current root is the closest value.
    //if not, we keep going find the closest value.
    //then we compare either root.val or the other result is closer.
    public int closestValue(TreeNode root, double target) {
        TreeNode child = target < root.val ? root.left : root.right;
        if(child == null) return root.val;
        int tempResult = closestValue(child, target);
        return Math.abs(root.val - target) < Math.abs(tempResult - target) ? root.val : tempResult;
    }

}
