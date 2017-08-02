package leetcode.medium;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/5/20.
 */
public class BoundaryOfBinaryTree {
    //Level order traversal


    /**
     *
     * if not adding root separately,
     * leaves will add it twice if only root node.
     * boundary will add it twice if root is not a leaf.
     *
     * So we add root to result.
     *
     * 1. Left boundary, leaves excluded.
     * 2. Right boundary, leaves excluded.
     * 3. Left leaves,
     * 4. Right leaves.
     * */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        result.add(root.val);
        leftBoundary(root.left, result);
        leaves(root.left,result);
        leaves(root.right, result);
        rightBoundary(root.right, result);
        return result;
    }

    /*
    * only left boundary, ignore leaf node
    * */
    public void leftBoundary(TreeNode root, List<Integer> result){
        if(root == null || (root.left == null && root.right == null)) return;
        result.add(root.val);
        if(root.left == null) leftBoundary(root.right,result);
        else leftBoundary(root.left, result);
    }

    //anti-clock wise, so add value at the end, so that sequence match.
    public void rightBoundary(TreeNode root, List<Integer> result){
        if(root == null || (root.left == null && root.right == null)) return;
        if(root.right == null) rightBoundary(root.left,result);
        else rightBoundary(root.right, result);
        result.add(root.val);
    }

    //leaves, pre-order traversal
    public void leaves(TreeNode root, List<Integer> result){
        if(root == null) return;
        if(root.left == null && root.right == null){
            result.add(root.val);
            return;
        }
        leaves(root.left, result);
        leaves(root.right, result);
    }
}



