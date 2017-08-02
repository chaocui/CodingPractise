package leetcode.medium;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/3/16.
 */
public class DeleteNodeInaBST {

    //find the key,
    //find the key's right sub tree left most.
    //set value as that value, delete the right subtree left most.
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key < root.val)
            root.left = deleteNode(root.left,key);
        else if(key > root.val)
            root.right = deleteNode(root.right, key);
        else{
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;
            root.val = findLeftMost(root.right).val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode findLeftMost(TreeNode node){
        TreeNode result = node;
        while(result.left != null){
            result = result.left;
        }
        return result;
    }
}
