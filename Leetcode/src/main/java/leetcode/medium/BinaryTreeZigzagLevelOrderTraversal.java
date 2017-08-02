package leetcode.medium;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cc on 2017/2/6.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    //Tree level traversal.
    //basic idea is modification of level traversal.
    //for each level, always loop through from right to left.

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Deque<TreeNode> level = new LinkedList<TreeNode>();
        if(root == null) return result;
        level.add(root);
        int count = 1;
        while(!level.isEmpty()){
            Deque<TreeNode> copyLevel = new LinkedList<TreeNode>(level);
            List<Integer> eachResult = new ArrayList<Integer>();
            level.clear();
            while(!copyLevel.isEmpty()){
                TreeNode node = copyLevel.pollLast();
                eachResult.add(node.val);
                //But, when add left, right child to next level.
                //if even level number, add right, then left.
                //if odd level number, add left ,then right.

                //if odd number, left to right
                if(count%2 == 1) {
                    if (node.left != null) level.add(node.left);
                    if (node.right != null) level.add(node.right);
                }
                //if even number, right to left.
                else{
                    if (node.right != null) level.add(node.right);
                    if (node.left != null) level.add(node.left);
                }
            }
            result.add(eachResult);
            count ++;
        }
        return result;
    }
}
