package leetcode.easy;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/4/23.
 */
public class BinaryTreePath {

    /**
     * Basic recursive binary tree solution.
     * Just do left, right.
     * append left, right to root.
     * add to result.
     * if left and right are empty means root is leaf.
     * only add root to result.
     * */
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
            return new ArrayList<String>();

        List<String> result = new ArrayList<String>();
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);

        if(left.size() != 0){
            for(String s : left)
                result.add(root.val+"->"+s);
        }
        if(right.size() != 0){
            for(String s : right)
                result.add(root.val+"->"+s);
        }
        if(left.size() == 0 && right.size() == 0)
            result.add(root.val + "");

        return result;
    }

}
