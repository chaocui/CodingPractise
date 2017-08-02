package leetcode.easy;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2016/4/4.
 */
public class SameBTree {

    public boolean isSameTree(TreeNode p, TreeNode q){

        //if all null, they are equal
        if(p == null && q == null)
            return true;
        //not all null, if one of them is null, return false
        else if( p == null || q == null)
            return false;
        //if none of them is null, compare value, if not equal, return false,
        else if(p.val != q.val)
            return false;
        //if none of them is null and value equals, compare left, and right. if both equals, return true.
        else{
            boolean leftSame = isSameTree(p.left, q.left);
            boolean rightSame = isSameTree(p.right, q.right);
            if(leftSame && rightSame)
                return true;
            else
                return false;
        }
    }

}
