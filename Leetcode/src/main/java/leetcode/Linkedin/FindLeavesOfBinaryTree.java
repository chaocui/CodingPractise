package leetcode.Linkedin;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/6/24.
 */
public class FindLeavesOfBinaryTree {
    /**
     * Brilliant idea,
     * define height of each node.
     * basically, just group node which have the same level
     * when calculate height, take the max one from left and right.
     * This is bottom-up,
     * So after each recursion, we add one more list to result.
     * until result.size() == root height.
     *
     * result index just corresponding the level.
     * So if null return -1;
     * */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        height(root, result);
        return result;
    }

    public int height(TreeNode root, List<List<Integer>> result){
        if(root == null) return -1;
        int currentLevel = 1 + Math.max(height(root.left, result), height(root.right, result));
        if(result.size() < currentLevel+1) result.add(new ArrayList<Integer>());
        result.get(currentLevel).add(root.val);
        return currentLevel;
    }

}
