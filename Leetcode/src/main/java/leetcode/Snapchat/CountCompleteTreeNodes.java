package leetcode.Snapchat;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/6/16.
 */
public class CountCompleteTreeNodes {

    /*  Since it is complete binary tree.
        height always 1 + leftTreeHeight.
        Also, if right subtree is treeHeight - 1, means left side is filled up.

        if binary tree is all filled up, then the total number of node is 2^h  - 1. h is the number of levels.
        left sub tree is (2^h - 1 - 1)/2 which is 2^(h-1) - 1, plus root, which is 2^(h-1). h is the height.
    **/

    public int height(TreeNode root){
        if(root == null) return 0;
        return 1 + height(root.left);
    }


    public int countNodes(TreeNode root) {
        int h = height(root);
        if(h == 1) return 1;
        if(h == 0) return 0;
        return height(root.right) == h - 1 ? (1<<h-1) + countNodes(root.right) : (1 << h - 2) + countNodes(root.left);
    }

}
