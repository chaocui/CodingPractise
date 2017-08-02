package leetcode.medium;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/5/20.
 */
public class LargestBSTSubtree {

    public class Result{
        int size, lower, upper;
        public Result(int size, int lower, int upper){
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }

    int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        traverse(root);
        return max;
    }

    public Result traverse(TreeNode root){
        //To make sure that any parent value bigger than upper, smaller than lower, so make upper minimum, lower maximu.
        if(root == null) return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Result left = traverse(root.left);
        Result right = traverse(root.right);
        //not a binary search tree
        if(left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower)
            return new Result(-1, 0, 0);
        //is bst, so add root to total size
        int size = 1 + left.size + right.size;
        max = Math.max(max, size);
        //return new lower and upper with size.
        //Since left or right might be null, so upper might be Integer.MIN_VALUE
        //lower might be Integer.MAX_VALUE.
        //we need to update to root value if thats the case. so we need to compare.
        return new Result(size, Math.min(root.val, left.lower), Math.max(root.val, right.upper));
    }
}
