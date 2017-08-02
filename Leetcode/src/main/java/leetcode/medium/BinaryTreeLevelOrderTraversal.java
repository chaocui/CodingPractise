package leetcode.medium;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by cc on 2017/3/20.
 */
public class BinaryTreeLevelOrderTraversal {

    //can use queue
    //how to determine size of each level,
    //initialize queue with root.
    //before loop through each level, we get queue size, which is the level size.
    //we only loop this many times to pop from queue.
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) return result;
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> eachResult = new ArrayList<Integer>();
            for(int i = 0; i < levelSize; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                eachResult.add(queue.poll().val);
            }
            result.add(eachResult);
        }
        return result;
    }

    public List<List<Integer>> levelOrderII(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        List<TreeNode> eachLevel = new ArrayList<TreeNode>();
        eachLevel.add(root);
        List<Integer> firstResult = new ArrayList<Integer>();
        firstResult.add(root.val);
        result.add(firstResult);
        while(eachLevel.size() != 0){
            List<TreeNode> copy = new ArrayList<TreeNode>(eachLevel);
            eachLevel.clear();
            List<Integer> tempResult = new ArrayList<Integer>();
            for(TreeNode node : copy){
                if(node.left != null){
                    eachLevel.add(node.left);
                    tempResult.add(node.left.val);
                }
                if(node.right != null){
                    eachLevel.add(node.right);
                    tempResult.add(node.right.val);
                }
            }
            if(tempResult.size() != 0)
                result.add(tempResult);
        }
        return result;
    }
}
