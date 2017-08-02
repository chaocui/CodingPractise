package leetcode.medium;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/2/16.
 */
public class CountCompleteTreeNodes {

    //since its complete tree, just keep go to left.
    private int height(TreeNode root){
        if(root == null) return -1;
        return 1 + height(root.left);
    }

    //Explanation.
    //root height 0,
    //for height n complete tree, total number of nodes are 2^(n+1) - 1
    //So height h - 1, total number is 2^h - 1;
    //Since its complete binary tree,

    //if right tree height is h - 1, means left tree is complete.
    //So left tree nodes are 2^h - 1 + 1(root) which is 2^h plus recursive get right side.

    //if not, means, left tree is not complete, but right tree is complete with height h - 2.
    //so right side nodes are 2^(h-1) - 1 + 1(root) is 2^(h-1) plus recursive get left side.

    //1<<h is 1*2^h.
    public int countNodes(TreeNode root) {
        int h = height(root);
        if(h == -1) return 0;
        return height(root.right) == h-1 ? (1<<h) + countNodes(root.right) : (1 << h-1) + countNodes(root.left);
    }

}
