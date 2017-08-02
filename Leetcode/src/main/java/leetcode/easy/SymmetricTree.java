package leetcode.easy;

import leetcode.util.TreeNode;

import java.util.Collections;
import java.util.Map;

/**
 * Created by cc on 2016/4/12.
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root){

        if(root == null)
            return true;

        TreeNode reversedLeft = revertTree(root.left);

        return sameTree(root.right, reversedLeft);

    }

    private TreeNode revertTree(TreeNode n){

        if( n == null)
            return null;

        TreeNode left = revertTree(n.left);
        TreeNode right = revertTree(n.right);
        n.left = right;
        n.right = left;
        return n;
    }

    private boolean sameTree(TreeNode l, TreeNode r){

        if(l == null && r == null)
            return true;

        if(l == null || r == null)
            return false;

        if(l.val != r.val)
            return false;

        return sameTree(l.left, r.left) && sameTree(l.right, r.right);
    }

    public boolean isSymmetricNonRecursive(TreeNode root){
        //Map cm = Collections.checkedMap();
        return false;
    }

}
