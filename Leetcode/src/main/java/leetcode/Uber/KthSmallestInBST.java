package leetcode.Uber;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/6/11.
 */
public class KthSmallestInBST {

    public int kthSmallest(TreeNode root, int k) {
        int count = count(root.left);
        if(count == k - 1)
            return root.val;
        if(k <= count) return kthSmallest(root.left, k);
        if(k > count + 1) return kthSmallest(root.right, k - count - 1);
        return -1;
    }

    public int count(TreeNode node){
        if(node == null) return 0;
        return 1 + count(node.left) + count(node.right);
    }

}
