package leetcode.easy;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2016/3/29.
 */
public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode node){
        if(node == null)
            return 0;
        else{
            int leftDepth = maxDepth(node.left);
            int rightDepth = maxDepth(node.right);
            return 1 + (leftDepth >= rightDepth ? leftDepth : rightDepth);
        }
    }

}
