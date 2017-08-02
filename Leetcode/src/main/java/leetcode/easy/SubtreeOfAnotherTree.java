package leetcode.easy;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/5/28.
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if(sameTree(s,t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean sameTree(TreeNode l, TreeNode r){
        if(l == null && r == null) return true;
        if(l == null || r == null) return false;
        if(l.val == r.val)
            return sameTree(l.left, r.left) && sameTree(l.right, r.right);
        return false;
    }
}
