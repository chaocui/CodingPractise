package leetcode.medium;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/3/18.
 */
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return getResult(root, 0);
    }

    private int getResult(TreeNode node, int sum){
        //if node is null, meaning path not exist.
        if(node == null) return 0;
        //if node is leaf, calculate the number and return it.
        //sum is the parent path number.
        if(node.left == null && node.right == null) return sum*10+node.val;
        //if node is not leaf, go left and right with the current path value.
        return getResult(node.left,sum*10 + node.val) + getResult(node.right, sum*10 + node.val);
    }

}
