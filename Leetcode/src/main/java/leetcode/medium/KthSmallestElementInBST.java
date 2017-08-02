package leetcode.medium;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/3/28.
 */
public class KthSmallestElementInBST {

    //recursively call
    //check the value is in left subtree or right subtree.
    public int kthSmallest(TreeNode root, int k) {
        int countLeftSubTree = count(root.left);
        if(k <= countLeftSubTree)
            return kthSmallest(root.left, k);
        //if it is not in left, it is in right,
        //so the problem become find k - countLeftSubTree - 1 from right sub Tree.
        else if(k > countLeftSubTree + 1)
            return kthSmallest(root.right, k - countLeftSubTree - 1);
        //if k is count + 1, then means root is the one we are looking for.
        return root.val;
    }

    private int count(TreeNode node){
        if(node == null) return 0;
        return 1 + count(node.left) + count(node.right);
    }

}
