package leetcode.Linkedin;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/6/24.
 */
public class BinaryTreeUpsideDown {

    //recursive way
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null)
            return root;
        TreeNode result = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return result;
    }

    //iterative way
    public TreeNode upsideDownBinaryTree1(TreeNode root) {
        TreeNode current = root, pre = null, next = null, right = null;
        while(current != null){
            next = current.left;

            current.left = right;
            right = current.right;
            current.right = pre;

            pre = current;
            current = next;
        }
        return pre;
    }




}
