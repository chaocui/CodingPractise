package leetcode.medium;

import leetcode.util.TreeNode;

import java.util.HashMap;

/**
 * Created by cc on 2017/3/28.
 */
public class HouseRobberIII {

    //basic idea.
    //recursively call
    //rob root, then cannot rob root.left and root.right.
    //not rob root. rob root.left and root.right.
    public int rob1(TreeNode root) {

        if(root == null) return 0;

        //not rob root left, rob root.left.left and root.left.right;
        int val = 0;
        if(root.left != null)
            val += rob1(root.left.left) + rob1(root.left.right);

        //not rob root right, rob root.right.left and root.right.right;
        if(root.right != null)
            val += rob1(root.right.left) + rob1(root.right.right);

        //second parameter is not rob root, so we can rob root.left and root.right.
        return Math.max(root.val + val, rob1(root.left) + rob1(root.right));
    }

    //We can optimise using a map to keep track the value of each node to reduce recalculation.
    public int rob2(TreeNode root){
        return getResult2(root, new HashMap<TreeNode, Integer>());
    }
    public int getResult2(TreeNode root, HashMap<TreeNode, Integer> map) {
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);

        //not rob root left, rob root.left.left and root.left.right;
        int val = 0;
        if(root.left != null)
            val += getResult2(root.left.left,map) + getResult2(root.left.right,map);

        //not rob root right, rob root.right.left and root.right.right;
        if(root.right != null)
            val += getResult2(root.right.left,map) + getResult2(root.right.right,map);

        //second parameter is not rob root, so we can rob root.left and root.right.
        return Math.max(root.val + val, getResult2(root.left,map) + getResult2(root.right,map));

    }

    //Idea 3, we just keep track for each node, rob it or not, the maximum by using a array.
    public int rob(TreeNode root){
        int[] result = rob3(root);
        return Math.max(result[0], result[1]);
    }

    //0 is not rob root. max
    //1 is rob root max
    public int[] rob3(TreeNode root) {

        if(root == null) return new int[2];

        int[] leftResult = rob3(root.left);
        int[] rightResult = rob3(root.right);
        int[] result = new int[2];

        //if not rob root. we can either rob left or not, same for right.
        //so we take the maximum of those two.
        result[0] = Math.max(leftResult[0],leftResult[1]) + Math.max(rightResult[0],rightResult[1]);
        //if we rob root
        //we cannot rob root.left and root.right. we can only take 0 of left and right.
        result[1] = root.val + leftResult[0] + rightResult[0];
        return result;
    }








}
