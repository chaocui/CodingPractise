package leetcode.Pinterest;

import leetcode.util.TreeNode;

import java.util.*;

/**
 * Created by cc on 2017/6/20.
 */
public class BTZigZagTraverse {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int level = 1;
        while(!deque.isEmpty()){
            Deque<TreeNode> tempDeque = new LinkedList<>(deque);
            List<Integer> temp = new ArrayList<>();
            deque.clear();
            while(!tempDeque.isEmpty()){
                TreeNode node = tempDeque.pollLast();
                temp.add(node.val);
                if(level%2 == 1){
                    if(node.left != null ) deque.add(node.left);
                    if(node.right != null ) deque.add(node.right);
                }
                else{
                    if(node.right != null ) deque.add(node.right);
                    if(node.left != null ) deque.add(node.left);
                }
            }
            level++;
            result.add(temp);
        }
        return result;
    }

}
